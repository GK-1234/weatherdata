package com.stylus.weatherdata.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import com.stylus.weatherdata.domain.flat.WeatherData;

public interface WeatherRepository extends CrudRepository<WeatherData, Long> {

//	@Query("select f1 from WeatherData w where w.name = :city ")
	Iterable<WeatherData> findByCity(String city);

	Optional<WeatherData> findByCityName(String city);

}
