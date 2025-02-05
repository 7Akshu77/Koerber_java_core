package com.weatherClient.WeatherClient.service;

import com.weatherClient.WeatherClient.WeatherClientApplication;
import com.weatherClient.WeatherClient.dto.WeatherInfo;

import java.time.LocalDateTime;
import java.util.Date;

public class WeatherServiceImpl implements WeatherService {


    @Override
    public void getMessage(int temp , String message) {
        WeatherInfo weatherInfo = new WeatherInfo(temp, LocalDateTime.now());


    }
}
