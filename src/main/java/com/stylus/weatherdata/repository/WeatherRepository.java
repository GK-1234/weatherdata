package com.stylus.weatherdata.repository;

import org.springframework.data.repository.CrudRepository;

import com.stylus.weatherdata.domain.flat.WeatherData;

public interface WeatherRepository extends CrudRepository<WeatherData, Long> {

	Iterable<WeatherData> findByCity(String city);

}
