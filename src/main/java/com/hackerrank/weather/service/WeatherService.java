package com.hackerrank.weather.service;

import com.hackerrank.weather.model.Weather;

import java.util.Date;
import java.util.List;

public interface WeatherService {

    void createWeather(Weather weather);

    Weather getWeatherByLocation(Float lat, Float lon);

    void deleteByDateAndLocation(Date start, Date end, Float lat, Float lon);

    Weather getWeatherByDate(Date start, Date end);

    List<Weather> getAllWeathers();

}
