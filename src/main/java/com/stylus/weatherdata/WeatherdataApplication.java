package com.stylus.weatherdata;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.stylus.weatherdata.domain.flat.WeatherData;
import com.stylus.weatherdata.service.FlatDataWeatherService;

@SpringBootApplication
public class WeatherdataApplication {

	@Autowired
	private FlatDataWeatherService weatherService;
	
	public static void main(String[] args) {
		SpringApplication.run(WeatherdataApplication.class, args);
	}

	
	@Bean
//	CommandLineRunner runner(WeatherService service) {
	CommandLineRunner runner() {
	
		return args -> {
			//read json
			ObjectMapper mapper = new ObjectMapper();
			mapper.disable(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES);
			mapper.disable(DeserializationFeature.FAIL_ON_UNRESOLVED_OBJECT_IDS);
			TypeReference<WeatherData> typeReference = new TypeReference<WeatherData>(){};
			
			InputStream instream = TypeReference.class.getResourceAsStream("/weather_01.json");
			BufferedReader reader = new BufferedReader(new InputStreamReader(instream));
			String line;
			int recCount = 0;
			while ((line = reader.readLine()) != null) {
				if (line.length()==0) break;
				//WeatherData weatherData = mapper.readValue(instream, typeReference);
				try {
				WeatherData weatherData = mapper.readValue(line, typeReference);
				weatherService.save(weatherData);
				recCount++;
				System.out.println("Weatherdata Saved " + recCount);
				} catch (Exception e) {
					System.out.println("Weatherdata Saved " + recCount + "\n" + e.getMessage());
				}
			}
			System.out.println("Weatherdata Saved!");
			
		};
	}
}

