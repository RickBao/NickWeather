package com.example.myapplication.data.db.entities.minimalist;

import com.j256.ormlite.field.DatabaseField;
import com.j256.ormlite.table.DatabaseTable;

import java.util.List;

@DatabaseTable(tableName = "Weather")
public class Weather {

    public static final String CITY_ID_FIELD_NAME = "cityId";
    public static final String CITY_NAME_FIELD_NAME = "cityName";
    public static final String CITY_NAME_EN_FIELD_NAME = "cityNameEn";

    @DatabaseField(columnName = CITY_ID_FIELD_NAME, id = true)
    private String cityID;

    @DatabaseField(columnName = CITY_NAME_FIELD_NAME)
    private String cityName;

    @DatabaseField(columnName = CITY_NAME_EN_FIELD_NAME)
    private String cityNameEn;

    private WeatherLive weatherLive;

    private List<WeatherForecast> weatherForecastList;

    private AirQualityLive airQualityLive;

    private List<LifeIndex> lifeIndices;

    public String getCityID() {
        return cityID;
    }

    public void setCityID(String cityID) {
        this.cityID = cityID;
    }

    public String getCityName() {
        return cityName;
    }

    public void setCityName(String cityName) {
        this.cityName = cityName;
    }

    public String getCityNameEn() {
        return cityNameEn;
    }

    public void setCityNameEn(String cityNameEn) {
        this.cityNameEn = cityNameEn;
    }

    public WeatherLive getWeatherLive() {
        return weatherLive;
    }

    public void setWeatherLive(WeatherLive weatherLive) {
        this.weatherLive = weatherLive;
    }

    public List<WeatherForecast> getWeatherForecastList() {
        return weatherForecastList;
    }

    public void setWeatherForecastList(List<WeatherForecast> weatherForecastList) {
        this.weatherForecastList = weatherForecastList;
    }

    public AirQualityLive getAirQualityLive() {
        return airQualityLive;
    }

    public void setAirQualityLive(AirQualityLive airQualityLvie) {
        this.airQualityLive = airQualityLvie;
    }

    public List<LifeIndex> getLifeIndices() {
        return lifeIndices;
    }

    public void setLifeIndices(List<LifeIndex> lifeIndices) {
        this.lifeIndices = lifeIndices;
    }

    @Override
    public String toString() {
        return "Weather{" +
                "cityID='" + cityID + '\'' +
                ", cityName='" + cityName + '\'' +
                ", cityNameEn='" + cityNameEn + '\'' +
                ", weatherLive=" + weatherLive +
                ", weatherForecastList=" + weatherForecastList +
                ", airQualityLvie=" + airQualityLive +
                ", lifeIndices=" + lifeIndices +
                '}';
    }
}
