package com.example.myapplication.data.repository;

import android.content.Context;
import android.text.TextUtils;

import com.example.library.NetworkUtils;
import com.example.myapplication.data.db.dao.WeatherDao;
import com.example.myapplication.data.db.entities.adapter.CloudWeatherAdapter;
import com.example.myapplication.data.db.entities.adapter.KnowWeatherAdapter;
import com.example.myapplication.data.db.entities.adapter.MiWeatherAdapter;
import com.example.myapplication.data.db.entities.minimalist.Weather;
import com.example.myapplication.data.http.ApiClient;
import com.example.myapplication.data.http.ApiConstants;
import com.example.myapplication.data.http.entity.envicloud.EnvironmentCloudCityAirLive;
import com.example.myapplication.data.http.entity.envicloud.EnvironmentCloudForecast;
import com.example.myapplication.data.http.entity.envicloud.EnvironmentCloudWeatherLive;

import java.sql.SQLException;

import rx.Observable;
import rx.exceptions.Exceptions;
import rx.schedulers.Schedulers;

public class WeatherDataRepository {

    public static Observable<Weather> getWeather(Context context, String cityId, WeatherDao weatherDao, boolean refreshNow) {

        //从数据库获取天气数据
        Observable<Weather> observableForGetWeatherFromDB = Observable.create(subscriber -> {
           try {
               Weather weather = weatherDao.queryWeather(cityId);
               subscriber.onNext(weather);
               subscriber.onCompleted();
           } catch (SQLException e) {
               throw Exceptions.propagate(e);
           }
        });

        if (!NetworkUtils.isNetworkConnected(context)) {
            return observableForGetWeatherFromDB;
        }

        Observable<Weather> observableForGetWeatherFromNetwork = null;
        switch (ApiClient.configuration.getDataSourceType()) {
            case ApiConstants.WEATHER_DATA_SOURCE_TYPE_KNOW:
                observableForGetWeatherFromNetwork = ApiClient.weatherService.getKnowWeather(cityId)
                        .map(knowWeather -> new KnowWeatherAdapter(knowWeather).getWeather());
                break;
            case ApiConstants.WEATHER_DATA_SOURCE_TYPE_MI:
                observableForGetWeatherFromNetwork = ApiClient.weatherService.getMiWeather(cityId)
                        .map(miWeather -> new MiWeatherAdapter(miWeather).getWeather());
                break;
            case ApiConstants.WEATHER_DATA_SOURCE_TYPE_ENVIRONMENT_CLOUD:
                Observable<EnvironmentCloudWeatherLive> weatherLiveObservable = ApiClient.environmentCloudWeatherService
                        .getWeatherLive(cityId);
                Observable<EnvironmentCloudForecast> forecastObservable = ApiClient.environmentCloudWeatherService
                        .getWeatherForecast(cityId);
                Observable<EnvironmentCloudCityAirLive> cityAirLiveObservable = ApiClient.environmentCloudWeatherService
                        .getAirLive(cityId);

                observableForGetWeatherFromNetwork = Observable.combineLatest(weatherLiveObservable, forecastObservable, cityAirLiveObservable,
                        (weatherLive, forecast, airLive) -> new CloudWeatherAdapter(weatherLive, forecast, airLive).getWeather());
                break;
        }

        assert observableForGetWeatherFromNetwork != null;
        observableForGetWeatherFromNetwork = observableForGetWeatherFromNetwork.doOnNext(weather ->
                Schedulers.io().createWorker().schedule(() -> {
                    try {
                        weatherDao.insertOrUpdateWeather(weather);
                    } catch (SQLException e) {
                        throw Exceptions.propagate(e);
                    }
                }));

        return Observable.concat(observableForGetWeatherFromDB, observableForGetWeatherFromNetwork)
                .filter(weather -> weather != null && !TextUtils.isEmpty(weather.getCityID()))
                .distinct(weather -> weather.getWeatherLive().getTime())
                .takeUntil(weather -> !refreshNow && System.currentTimeMillis() - weather.getWeatherLive().getTime() <= 15 * 60 * 1000);
    }
}
