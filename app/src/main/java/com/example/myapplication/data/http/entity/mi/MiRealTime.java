package com.example.myapplication.data.http.entity.mi;

import com.alibaba.fastjson.annotation.JSONField;

public class MiRealTime {

    @JSONField(name = "SD")
    private String humidity;    //湿度

    @JSONField(name = "WD")
    private String wind;        //风向

    @JSONField(name = "WS")
    private String windSpeed;   //风速

    @JSONField(name = "cityid")
    private String cityId;

    private String temp;        //温度
    private String time;        //发布时间
    private String weather;     //天气情况

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

    public String getCityId() {
        return cityId;
    }

    public void setCityId(String cityId) {
        this.cityId = cityId;
    }

    public String getTemp() {
        return temp;
    }

    public void setTemp(String temp) {
        this.temp = temp;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public String getWeather() {
        return weather;
    }

    public void setWeather(String weather) {
        this.weather = weather;
    }

    @Override
    public String toString() {
        return "MiRealTime{" +
                "humidity='" + humidity + '\'' +
                ", wind='" + wind + '\'' +
                ", windSpeed='" + windSpeed + '\'' +
                ", cityId='" + cityId + '\'' +
                ", temp='" + temp + '\'' +
                ", time='" + time + '\'' +
                ", weather='" + weather + '\'' +
                '}';
    }
}
