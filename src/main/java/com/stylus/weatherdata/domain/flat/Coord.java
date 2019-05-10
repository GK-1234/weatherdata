package com.stylus.weatherdata.domain.flat;

import lombok.AllArgsConstructor;
import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Embeddable;

import com.fasterxml.jackson.annotation.JsonProperty;

@Data
@AllArgsConstructor
@Embeddable
public class Coord {

    @JsonProperty("lon")
    @Column(nullable = true)
    private Double lon;
    @JsonProperty("lat")
    @Column(nullable = true)
    private Double lat;

    public Coord() {}
}
