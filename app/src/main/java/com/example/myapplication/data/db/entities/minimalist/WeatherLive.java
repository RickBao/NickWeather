package com.example.myapplication.data.db.entities.minimalist;

import com.j256.ormlite.field.DatabaseField;
import com.j256.ormlite.table.DatabaseTable;

@DatabaseTable(tableName = "WeatherLive")
public class WeatherLive {

    public static final String CITY_ID_FIELD_NAME = "cityId";
    public static final String WEATHER_FIELD_NAME = "weather";
    public static final String TEMP_FIELD_NAME = "temp";
    public static final String HUMIDITY_FIELD_NAME = "humidity";
    public static final String WIND_FIELD_NAME = "wind";
    public static final String WIND_SPEED_FIELD_NAME = "windSpeed";
    public static final String TIME_FIELD_NAME = "time";

    public static final String WIND_POWER_FIELD_NAME = "windPower";
    public static final String RAIN_FIELD_NAME = "rain";
    public static final String FEELS_TEMP_FIELD_NAME = "feelsTemp";
    public static final String PRESSURE_FIELD_NAME = "airPressunre";

    @DatabaseField(columnName = CITY_ID_FIELD_NAME)
    private String cityId;

    @DatabaseField(columnName = WEATHER_FIELD_NAME)
    private String weather;

    @DatabaseField(columnName = TEMP_FIELD_NAME)
    private String temp;

    @DatabaseField(columnName = HUMIDITY_FIELD_NAME)
    private String humidity;

    @DatabaseField(columnName = WIND_FIELD_NAME)
    private String wind;

    @DatabaseField(columnName = WIND_SPEED_FIELD_NAME)
    private String windSpeed;

    @DatabaseField(columnName = TIME_FIELD_NAME)
    private long time;

    @DatabaseField(columnName = WIND_POWER_FIELD_NAME)
    private String windPower;

    @DatabaseField(columnName = RAIN_FIELD_NAME)
    private String rain;

    @DatabaseField(columnName = FEELS_TEMP_FIELD_NAME)
    private String feelsTemp;

    @DatabaseField(columnName = PRESSURE_FIELD_NAME)
    private String airPressure;

    public WeatherLive() {

    }

    public WeatherLive(String cityId, String weather, String temp, String humidity, String wind,
                       String windSpeed, long time) {
        this.cityId = cityId;
        this.weather = weather;
        this.temp = temp;
        this.humidity = humidity;
        this.wind = wind;
        this.windSpeed = windSpeed;
        this.time = time;
    }

    public String getCityId() {
        return cityId;
    }

    public void setCityId(String cityId) {
        this.cityId = cityId;
    }

    public String getWeather() {
        return weather;
    }

    public void setWeather(String weather) {
        this.weather = weather;
    }

    public String getTemp() {
        return temp;
    }

    public void setTemp(String temp) {
        this.temp = temp;
    }

    public String getHumidity() {
        return humidity;
    }

    public void setHumidity(String humidity) {
        this.humidity = humidity;
    }

    public String getWind() {
        return wind;
    }

    public void setWind(String wind) {
        this.wind = wind;
    }

    public String getWindSpeed() {
        return windSpeed;
    }

    public void setWindSpeed(String windSpeed) {
        this.windSpeed = windSpeed;
    }

    public long getTime() {
        return time;
    }

    public void setTime(long time) {
        this.time = time;
    }

    public String getWindPower() {
        return windPower;
    }

    public void setWindPower(String windPower) {
        this.windPower = windPower;
    }

    public String getRain() {
        return rain;
    }

    public void setRain(String rain) {
        this.rain = rain;
    }

    public String getFeelsTemp() {
        return feelsTemp;
    }

    public void setFeelsTemp(String feelsTemp) {
        this.feelsTemp = feelsTemp;
    }

    public String getAirPressure() {
        return airPressure;
    }

    public void setAirPressure(String airPressure) {
        this.airPressure = airPressure;
    }

    @Override
    public String toString() {
        return "WeatherLive{" +
                "cityId='" + cityId + '\'' +
                ", weather='" + weather + '\'' +
                ", temp='" + temp + '\'' +
                ", humidity='" + humidity + '\'' +
                ", wind='" + wind + '\'' +
                ", windSpeed='" + windSpeed + '\'' +
                ", time=" + time +
                ", windPower='" + windPower + '\'' +
                ", rain='" + rain + '\'' +
                ", feelsTemp='" + feelsTemp + '\'' +
                ", airPressure='" + airPressure + '\'' +
                '}';
    }
}
