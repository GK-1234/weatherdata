package com.stylus.weatherdata.service;

import com.stylus.weatherdata.domain.flat.WeatherData;
import com.stylus.weatherdata.repository.WeatherRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

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

    public Optional<WeatherData> getWeatherById(Long id) {
        return weatherRepository.findById(id);
    }

    public Optional<WeatherData> findByCityName(String city) {
        return weatherRepository.findByCityName(city);
    }

    public WeatherData save(WeatherData weatherdata) {
        return weatherRepository.save(weatherdata);
    }

    public void save(List<WeatherData> weatherdatas) {
        //userRepository.save(users);
    }
}
