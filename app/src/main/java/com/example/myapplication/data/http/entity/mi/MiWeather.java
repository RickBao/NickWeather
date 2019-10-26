package com.example.myapplication.data.http.entity.mi;


import com.alibaba.fastjson.annotation.JSONField;

import java.util.List;

public class MiWeather {

    private MiForecast forecast;

    @JSONField(name = "realtime")
    private MiRealTime realTime;

    private MiAQI aqi;

    @JSONField(name = "index")
    private List<MiIndex> indexList;

    private MiToday today;
    private MiToday yesterday;

    public MiForecast getForecast() {
        return forecast;
    }

    public void setForecast(MiForecast forecast) {
        this.forecast = forecast;
    }

    public MiRealTime getRealTime() {
        return realTime;
    }

    public void setRealTime(MiRealTime realTime) {
        this.realTime = realTime;
    }

    public MiAQI getAqi() {
        return aqi;
    }

    public void setAqi(MiAQI aqi) {
        this.aqi = aqi;
    }

    public List<MiIndex> getIndexList() {
        return indexList;
    }

    public void setIndexList(List<MiIndex> indexList) {
        this.indexList = indexList;
    }

    public MiToday getToday() {
        return today;
    }

    public void setToday(MiToday today) {
        this.today = today;
    }

    public MiToday getYesterday() {
        return yesterday;
    }

    public void setYesterday(MiToday yesterday) {
        this.yesterday = yesterday;
    }

    @Override
    public String toString() {
        return "MiWeather{" +
                "forecast=" + forecast +
                ", realTime=" + realTime +
                ", aqi=" + aqi +
                ", indexList=" + indexList +
                ", today=" + today +
                ", yesterday=" + yesterday +
                '}';
    }
}
