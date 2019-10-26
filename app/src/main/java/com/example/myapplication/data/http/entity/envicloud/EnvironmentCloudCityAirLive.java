package com.example.myapplication.data.http.entity.envicloud;

import com.alibaba.fastjson.annotation.JSONField;

/**
 * 城市实时天气质量
 */
public class EnvironmentCloudCityAirLive {

    @JSONField(name = "rcode")
    private int requestCode;    //结果码

    @JSONField(name = "rdesc")
    private String requestDesc;     //结果描述

    @JSONField(name = "citycode")
    private String cityId;          //城市ID

    private String time;            //时间

    @JSONField(name = "AQI")
    private String api;             //空气质量指数

    @JSONField(name = "PM25")
    private String pm25;            //PM2.5浓度

    @JSONField(name = "PM10")
    private String pm10;            //PM10浓度

    @JSONField(name = "CO")
    private String co;              //一氧化碳浓度

    @JSONField(name = "SO2")
    private String so2;             //二氧化硫浓度

    @JSONField(name = "NO2")
    private String no2;             //二氧化氮浓度

    private String o3;              //臭氧浓度

    private String primary;         //首要污染物

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

    public String getCityId() {
        return cityId;
    }

    public void setCityId(String cityId) {
        this.cityId = cityId;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public String getApi() {
        return api;
    }

    public void setApi(String api) {
        this.api = api;
    }

    public String getPm25() {
        return pm25;
    }

    public void setPm25(String pm25) {
        this.pm25 = pm25;
    }

    public String getPm10() {
        return pm10;
    }

    public void setPm10(String pm10) {
        this.pm10 = pm10;
    }

    public String getCo() {
        return co;
    }

    public void setCo(String co) {
        this.co = co;
    }

    public String getSo2() {
        return so2;
    }

    public void setSo2(String so2) {
        this.so2 = so2;
    }

    public String getNo2() {
        return no2;
    }

    public void setNo2(String no2) {
        this.no2 = no2;
    }

    public String getO3() {
        return o3;
    }

    public void setO3(String o3) {
        this.o3 = o3;
    }

    public String getPrimary() {
        return primary;
    }

    public void setPrimary(String primary) {
        this.primary = primary;
    }
}
