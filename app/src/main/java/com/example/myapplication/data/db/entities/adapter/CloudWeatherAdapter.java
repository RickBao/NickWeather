package com.example.myapplication.data.db.entities.adapter;

import com.example.myapplication.data.db.entities.minimalist.AirQualityLive;
import com.example.myapplication.data.db.entities.minimalist.LifeIndex;
import com.example.myapplication.data.db.entities.minimalist.WeatherForecast;
import com.example.myapplication.data.db.entities.minimalist.WeatherLive;

import java.util.List;

public class CloudWeatherAdapter extends WeatherAdapter {
    @Override
    public String getCityId() {
        return null;
    }

    @Override
    public String getCityName() {
        return null;
    }

    @Override
    public String getCityNameEn() {
        return null;
    }

    @Override
    public WeatherLive getWeatherLive() {
        return null;
    }

    @Override
    public List<WeatherForecast> getWeatherForecasts() {
        return null;
    }

    @Override
    public List<LifeIndex> getLifeIndexes() {
        return null;
    }

    @Override
    public AirQualityLive getAirQualityLive() {
        return null;
    }
}
