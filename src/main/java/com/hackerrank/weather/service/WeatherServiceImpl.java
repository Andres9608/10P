package com.hackerrank.weather.service;

import com.hackerrank.weather.model.Weather;
import com.hackerrank.weather.repository.WeatherRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service("weatherService")
public class WeatherServiceImpl implements WeatherService {

    @Autowired
    private WeatherRepository weatherRepository;

    @Override
    public void createWeather(Weather weather) {
        weatherRepository.save(weather);
    }

    @Override
    public Weather getWeatherByLocation(Float lat, Float lon) {
        return weatherRepository.getByLocation(lat, lon);
    }

    @Override
    public void deleteByDateAndLocation(Date start, Date end, Float lat, Float lon) {
        weatherRepository.deleteByDateAndLocation(start,end,lat, lon);
    }

    @Override
    public Weather getWeatherByDate(Date start, Date end) {
        return weatherRepository.getByDate(start,end);
    }

    @Override
    public List<Weather> getAllWeathers() {
        return weatherRepository.findAll();
    }
}
