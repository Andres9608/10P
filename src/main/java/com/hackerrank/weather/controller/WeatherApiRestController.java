package com.hackerrank.weather.controller;

import com.hackerrank.weather.model.Weather;
import com.hackerrank.weather.service.WeatherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.Date;
import java.util.List;


@RestController
public class WeatherApiRestController {

    @Autowired
    private WeatherService weatherService;

    @RequestMapping(value = "/weather", method = RequestMethod.POST, consumes = "application/json")
    @ResponseStatus(HttpStatus.CREATED)
    public void createNewWeather(@RequestBody @Valid Weather weather) {
        weatherService.createWeather(weather);
    }

    @RequestMapping(value = "/weather/{lat,lon}", method = RequestMethod.GET)
    @ResponseStatus(HttpStatus.OK)
    public Weather getWeatherByLatAndLon(Float lat, Float lon) {
        return weatherService.getWeatherByLocation(lat,lon);
    }

    @RequestMapping(value = "/erase/{start,end,lat,lon}", method = RequestMethod.DELETE)
    @ResponseStatus(HttpStatus.OK)
    public void deleteByDate(Date start, Date end, Float lat, Float lon) {
        weatherService.deleteByDateAndLocation(start,end,lat,lon);
    }

    @RequestMapping(value = "/model/{start,end}", method = RequestMethod.GET)
    @ResponseStatus(HttpStatus.OK)
    public Weather getWeatherByDate(Date start, Date end) {
        return weatherService.getWeatherByDate(start, end);
    }

    @RequestMapping(value = "/weather", method = RequestMethod.GET)
    @ResponseStatus(HttpStatus.OK)
    public List<Weather> getAllWeathers() {
        return weatherService.getAllWeathers();
    }
}
