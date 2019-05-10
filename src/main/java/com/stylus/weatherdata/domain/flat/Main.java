package com.stylus.weatherdata.domain.flat;

import lombok.AllArgsConstructor;
import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.persistence.FetchType;
import javax.persistence.MapsId;
import javax.persistence.OneToOne;

import com.fasterxml.jackson.annotation.JsonProperty;

@Data
@AllArgsConstructor
@Embeddable
public class Main {

    @JsonProperty("temp")
    @Column(nullable = true)
    private Double temp;
    @JsonProperty("pressure")
    @Column(nullable = true)
    private int pressure;
    @JsonProperty("humidity")
    @Column(nullable = true)
    private int humidity;
    
    @Column( name = "temp_min", nullable = true)
    @JsonProperty("temp_min")
    private Double tempMin;

    @Column( name = "temp_max", nullable = true)
    @JsonProperty("temp_max")
    private Double tempMax;
    
   // @OneToOne(fetch = FetchType.LAZY)
    //@MapsId
 
    public Main() {}
}
