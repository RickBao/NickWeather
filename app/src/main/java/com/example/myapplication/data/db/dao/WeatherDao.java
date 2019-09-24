package com.example.myapplication.data.db.dao;

import android.content.Context;
import android.widget.LinearLayout;

import com.example.myapplication.data.db.WeatherDatabaseHelper;
import com.example.myapplication.data.db.entities.minimalist.AirQualityLive;
import com.example.myapplication.data.db.entities.minimalist.LifeIndex;
import com.example.myapplication.data.db.entities.minimalist.Weather;
import com.example.myapplication.data.db.entities.minimalist.WeatherForecast;
import com.example.myapplication.data.db.entities.minimalist.WeatherLive;
import com.j256.ormlite.dao.Dao;
import com.j256.ormlite.misc.TransactionManager;
import com.j256.ormlite.stmt.DeleteBuilder;
import com.j256.ormlite.stmt.PreparedDelete;

import java.sql.SQLException;
import java.util.List;
import java.util.concurrent.Callable;

import javax.inject.Inject;

public class WeatherDao {

    private Context context;

    private Dao<AirQualityLive, String> apiDaoOperation;
    private Dao<WeatherForecast, Long> forecastDaoOperation;
    private Dao<LifeIndex, Long> lifeIndexesDaoOperation;
    private Dao<WeatherLive, String> realTimeDaoOperation;
    private Dao<Weather, String> weatherDaoOperation;

    @Inject
    WeatherDao(Context context) {
        this.context = context;
        this.apiDaoOperation = WeatherDatabaseHelper.getInstance(context).getWeatherDao(AirQualityLive.class);
        this.forecastDaoOperation = WeatherDatabaseHelper.getInstance(context).getWeatherDao(WeatherForecast.class);
        this.lifeIndexesDaoOperation = WeatherDatabaseHelper.getInstance(context).getWeatherDao(LifeIndex.class);
        this.realTimeDaoOperation = WeatherDatabaseHelper.getInstance(context).getWeatherDao(WeatherLive.class);
        this.weatherDaoOperation = WeatherDatabaseHelper.getInstance(context).getWeatherDao(Weather.class);
    }

    public Weather queryWeather(String cityId) throws SQLException {

        return TransactionManager.callInTransaction(WeatherDatabaseHelper.getInstance(context).getConnectionSource(), () ->{
           Weather weather = weatherDaoOperation.queryForId(cityId);
           if (weather != null) {
               weather.setAirQualityLive(apiDaoOperation.queryForId(cityId));
               weather.setWeatherForecastList(forecastDaoOperation.queryForEq(WeatherForecast.CITY_ID_FIELD_NAME, cityId));
               weather.setLifeIndices(lifeIndexesDaoOperation.queryForEq(WeatherForecast.CITY_ID_FIELD_NAME, cityId));
               weather.setWeatherLive(realTimeDaoOperation.queryForId(cityId));
           }
           return weather;
        });
    }

    public void insertOrUpdateWeather(Weather weather) throws SQLException {

        TransactionManager.callInTransaction(WeatherDatabaseHelper.getInstance(context).getConnectionSource(), (Callable<Void>) () -> {
            if (weatherDaoOperation.idExists(weather.getCityID())) {
                updateWeather(weather);
            } else {
                insertWeather(weather);
            }

            return null;
        });
    }

    public void deleteById(String cityId) throws SQLException {
        weatherDaoOperation.deleteById(cityId);
    }

    private void delete(Weather weather) throws SQLException {
        weatherDaoOperation.delete(weather);
    }

    /**
     * 查询数据库中的所有已添加的城市
     * @return 结果集中只包括城市信息，天气数据不在其中
     * @throws SQLException
     */
    public List<Weather> queryAllSaveCity() throws SQLException {

        return TransactionManager.callInTransaction(WeatherDatabaseHelper.getInstance(context).getConnectionSource(), () -> {

            List<Weather> weatherList = weatherDaoOperation.queryForAll();
            for (Weather weather : weatherList) {
                String cityId = weather.getCityID();
                weather.setAirQualityLive(apiDaoOperation.queryForId(cityId));
                weather.setWeatherForecastList(forecastDaoOperation.queryForEq(WeatherForecast.CITY_ID_FIELD_NAME, cityId));
                weather.setLifeIndices(lifeIndexesDaoOperation.queryForEq(WeatherForecast.CITY_ID_FIELD_NAME, cityId));
                weather.setWeatherLive(realTimeDaoOperation.queryForId(cityId));
            }
            return weatherList;
        });
    }

    private void insertWeather(Weather weather) throws SQLException {

        weatherDaoOperation.create(weather);
        apiDaoOperation.create(weather.getAirQualityLive());
        for (WeatherForecast weatherForecast : weather.getWeatherForecastList()) {
            forecastDaoOperation.create(weatherForecast);
        }

        for (LifeIndex index : weather.getLifeIndices()) {
            lifeIndexesDaoOperation.create(index);
        }

        realTimeDaoOperation.create(weather.getWeatherLive());
    }

    private void updateWeather(Weather weather) throws SQLException {
        weatherDaoOperation.update(weather);
        apiDaoOperation.update(weather.getAirQualityLive());

        //先删除旧数据
        DeleteBuilder<WeatherForecast, Long> forecastDeleteBuilder = forecastDaoOperation.deleteBuilder();
        forecastDeleteBuilder.where().eq(WeatherForecast.CITY_ID_FIELD_NAME, weather.getCityID());
        PreparedDelete<WeatherForecast> forecastPreparedDelete = forecastDeleteBuilder.prepare();
        forecastDaoOperation.delete(forecastPreparedDelete);

        //再插入新数据
        for (WeatherForecast weatherForecast : weather.getWeatherForecastList()) {
            forecastDaoOperation.create(weatherForecast);
        }

        //先删除旧数据
        DeleteBuilder<LifeIndex, Long> lifeIndexDeleteBuilder = lifeIndexesDaoOperation.deleteBuilder();
        lifeIndexDeleteBuilder.where().eq(LifeIndex.CITY_ID_FIELD_NAME, weather.getCityID());
        PreparedDelete<LifeIndex> lifeIndexPrepared = lifeIndexDeleteBuilder.prepare();
        //再插入新数据
        for (LifeIndex index : weather.getLifeIndices()) {
            lifeIndexesDaoOperation.create(index);
        }
        realTimeDaoOperation.update(weather.getWeatherLive());
    }
}
