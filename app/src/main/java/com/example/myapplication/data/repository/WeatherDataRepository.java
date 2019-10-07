package com.example.myapplication.data.repository;

import android.content.Context;

import com.example.library.NetworkUtils;
import com.example.myapplication.data.db.dao.WeatherDao;
import com.example.myapplication.data.db.entities.minimalist.Weather;
import com.example.myapplication.data.http.ApiClient;

import java.sql.SQLException;

import rx.Observable;
import rx.exceptions.Exceptions;

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
        switch (ApiClient.)
    }
}
