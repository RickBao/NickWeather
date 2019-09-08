package com.example.myapplication.data.db.entities.adapter;

import com.example.myapplication.data.db.entities.minimalist.AirQualityLive;
import com.example.myapplication.data.db.entities.minimalist.LifeIndex;
import com.example.myapplication.data.db.entities.minimalist.Weather;
import com.example.myapplication.data.db.entities.minimalist.WeatherForecast;
import com.example.myapplication.data.db.entities.minimalist.WeatherLive;

import java.util.List;

public abstract class WeatherAdapter {

    public abstract String getCityId();

    public abstract String getCityName();

    public abstract String getCityNameEn();

    public abstract WeatherLive getWeatherLive();

    public abstract List<WeatherForecast> getWeatherForecasts();

    public abstract List<LifeIndex> getLifeIndexes();

    public abstract AirQualityLive getAirQualityLive();

    public Weather getWeather() {

        Weather weather = new Weather();
        weather.setCityID(getCityId());
        weather.setCityName(getCityName());
        weather.setCityNameEn(getCityNameEn());
        weather.setAirQualityLive(getAirQualityLive());
        weather.setWeatherForecastList(getWeatherForecasts());
        weather.setLifeIndices(getLifeIndexes());
        weather.setWeatherLive(getWeatherLive());

        return weather;
    }
}
