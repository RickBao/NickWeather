package com.example.myapplication.data.http.service;

import com.example.myapplication.data.http.entity.envicloud.EnvironmentCloudCityAirLive;
import com.example.myapplication.data.http.entity.envicloud.EnvironmentCloudForecast;
import com.example.myapplication.data.http.entity.envicloud.EnvironmentCloudWeatherLive;


import retrofit2.http.GET;
import retrofit2.http.Path;
import rx.Observable;

public interface EnvironmentCloudWeatherService {

    /**
     * 获取指定城市的实时天气
     * API地址：http://service.envicloud.cn:8082/v2/weatherlive/YMFYB256AGFUZZE0ODQ3MZM1MZE2NTU=/101020100
     * @param cityId 城市ID
     * @return 天气数据
     */
    @GET("/v2/weatherlive/YMFYB256AGFUZZE0ODQ3MZM1MZE2NTU=/{cityId}")
    Observable<EnvironmentCloudWeatherLive> getWeatherLive(@Path("cityId") String cityId);

    /**
     * 获取指定城市7日天气预报
     * API地址：http://service.envicloud.cn:8082/v2/weatherforecast/YMFYB256AGFUZZE0ODQ3MZM1MZE2NTU=/101020100
     * @param cityId 城市ID
     * @return 天气数据
     */
    @GET("/v2/weatherlive/YMFYB256AGFUZZE0ODQ3MZM1MZE2NTU=/{cityId}")
    Observable<EnvironmentCloudForecast> getWeatherForecast(@Path("cityId") String cityId);

    /**
     * 获取指定城市的实时空气质量
     * API地址：http://service.envicloud.cn:8082/v2/cityairlive/YMFYB256AGFUZZE0ODQ3MZM1MZE2NTU=/101020100
     * @param cityId 城市ID
     * @return 天气数据
     */
    @GET("/v2/cityairlive/YMFYB256AGFUZZE0ODQ3MZM1MZE2NTU=/{cityId}")
    Observable<EnvironmentCloudCityAirLive> getAirLive(@Path("cityId") String cityId);
}
