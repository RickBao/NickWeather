package com.example.myapplication.data.http.entity.envicloud;

import com.alibaba.fastjson.annotation.JSONField;

/**
 * 天气实况
 */
public class EnvironmentCloudWeatherLive {

    @JSONField(name = "rcode")
    private int requestCode;        //结果码

    @JSONField(name = "rdesc")
    private String requestDesc;     //结果描述

    @JSONField(name = "updatetime")
    private String updateTime;      //更新时间

    private String phenomena;       //天气现象

    private String temperature;     //气温

    @JSONField(name = "feelst")
    private String feelsTemperature;    //体感温度

    @JSONField(name = "airpressure")
    private String airPressure;     //气压

    private String humidity;        //相对湿度

    private String rain;            //降雨量

    @JSONField(name = "winddirect")
    private String windDirect;      //风向

    @JSONField(name = "windpower")
    private String windPower;       //风力

    @JSONField(name = "windspeed")
    private String windSpeed;       //风速

    @JSONField(name = "citycode")
    private String cityId;          //城市ID

    public int getRequestCode() {
        return requestCode;
    }

    public void setRequestCode(int requestCode) {
        this.requestCode = requestCode;
    }

    public String getRequestDesc() {
        return requestDesc;
    }

    public void setRequestDesc(String requestDesc) {
        this.requestDesc = requestDesc;
    }

    public String getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(String updateTime) {
        this.updateTime = updateTime;
    }

    public String getPhenomena() {
        return phenomena;
    }

    public void setPhenomena(String phenomena) {
        this.phenomena = phenomena;
    }

    public String getTemperature() {
        return temperature;
    }

    public void setTemperature(String temperature) {
        this.temperature = temperature;
    }

    public String getFeelsTemperature() {
        return feelsTemperature;
    }

    public void setFeelsTemperature(String feelsTemperature) {
        this.feelsTemperature = feelsTemperature;
    }

    public String getAirPressure() {
        return airPressure;
    }

    public void setAirPressure(String airPressure) {
        this.airPressure = airPressure;
    }

    public String getHumidity() {
        return humidity;
    }

    public void setHumidity(String humidity) {
        this.humidity = humidity;
    }

    public String getRain() {
        return rain;
    }

    public void setRain(String rain) {
        this.rain = rain;
    }

    public String getWindDirect() {
        return windDirect;
    }

    public void setWindDirect(String windDirect) {
        this.windDirect = windDirect;
    }

    public String getWindPower() {
        return windPower;
    }

    public void setWindPower(String windPower) {
        this.windPower = windPower;
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
}
