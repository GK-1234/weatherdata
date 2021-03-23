package com.stylus.weatherdata.controller;

import com.stylus.weatherdata.domain.flat.WeatherData;
import com.stylus.weatherdata.service.FlatDataWeatherService;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class WeatherController {

	@Autowired
    private FlatDataWeatherService weatherService;

	/*
    public WeatherController(WeatherService userService) {
        this.userService = userService;
    }
    */

    @GetMapping("/weather/city/{city}")
    public Optional<WeatherData> list(@PathVariable String city) {
        return weatherService.findByCityName(city);
    }

    @GetMapping("/weather/id/{weatherId}")
    public WeatherData getWeatherByid(@PathVariable Long weatherId) {
        return weatherService.getWeatherById(weatherId).get();
    }

    @GetMapping("/weather")
    public Iterable<WeatherData> list() {
        return weatherService.list();
    }

}
