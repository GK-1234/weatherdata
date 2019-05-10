package com.stylus.weatherdata.domain.flat;

import lombok.AllArgsConstructor;
import lombok.Data;

import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonProperty;

@Data
@AllArgsConstructor
@Embeddable
public class City {

	@JsonProperty("id")
	private Long id;
	@JsonProperty("name")
    private String name;
	@JsonProperty("findname")
    private String findname;
	@JsonProperty("country")
    private String country;

    @Embedded
    @JsonProperty("coord")
    private Coord coord;

    @JsonProperty("zoom")
    private int zoom;

    public City() {}
}
