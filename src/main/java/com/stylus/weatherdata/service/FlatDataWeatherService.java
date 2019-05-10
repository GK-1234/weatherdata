package com.stylus.weatherdata.service;

import com.stylus.weatherdata.domain.flat.WeatherData;
import com.stylus.weatherdata.repository.WeatherRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FlatDataWeatherService {

	@Autowired
    private WeatherRepository weatherRepository;

	/**
    public WeatherService(weatherRepository userRepository) {
        this.userRepository = userRepository;
    }
    */

    public Iterable<WeatherData> list() {
        return weatherRepository.findAll();
    }

    public Iterable<WeatherData> list(String city) {
        return weatherRepository.findByCity(city);
    }

    public WeatherData save(WeatherData weatherdata) {
        return weatherRepository.save(weatherdata);
    }

    public void save(List<WeatherData> weatherdatas) {
        //userRepository.save(users);
    }
}
