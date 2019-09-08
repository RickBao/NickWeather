package com.example.myapplication.data;

public class WeatherDetail {

    private int iconResourceId;
    private String key;
    private String value;

    public WeatherDetail(int iconResourceId, String key, String value) {
        this.iconResourceId = iconResourceId;
        this.key = key;
        this.value = value;
    }

    public int getIconResourceId() {
        return iconResourceId;
    }

    public String getKey() {
        return key;
    }

    public String getValue() {
        return value;
    }

    public void setIconResourceId(int iconResourceId) {
        this.iconResourceId = iconResourceId;
    }

    public void setKey(String key) {
        this.key = key;
    }

    public void setValue(String value) {
        this.value = value;
    }
}
