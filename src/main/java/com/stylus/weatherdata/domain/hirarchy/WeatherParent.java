package com.stylus.weatherdata.domain.hirarchy;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.AllArgsConstructor;
import lombok.Data;

import javax.persistence.*;

@Data
@AllArgsConstructor
@Entity
//@NamedQuery(name = "WeatherData.findByCity", query = "select w from WeatherData w where w.City.name = ?1")
public class WeatherParent {

	//@JsonIgnoreProperties(ignoreUnknown=true)

    @Id
    @GeneratedValue( strategy = GenerationType.AUTO )
    @Column(name = "weather_id", nullable = false , insertable=false , updatable=false)
    private Long weatherId;

    @Embedded
    @JsonProperty("city")
    private City city;

    @JsonProperty("time")
    private long time;
    
    @Embedded
    @JsonProperty("main")
    private Main main;

    @Embedded
    @JsonProperty("wind")
    private Wind wind;
/*
    @Embedded
    private Clouds clouds;

    //@OneToOne(cascade = CascadeType.ALL,fetch = FetchType.LAZY, optional = false)
    @Embedded
    private Weather weather;
*/
 
    public WeatherParent() {}
}
