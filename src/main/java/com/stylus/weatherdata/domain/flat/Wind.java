package com.stylus.weatherdata.domain.flat;

import javax.persistence.Column;
import javax.persistence.Embeddable;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
@Embeddable
public class Wind {

    @JsonProperty("speed")
    @Column(nullable = true)
	private Double speed;
    @JsonProperty("deg")
    @Column(nullable = true)
	private int deg;
	@Column (name = "var_beg", nullable = true)
    @JsonProperty("var_beg")
	private int varbeg;

	@Column (name = "var_end", nullable = true)
    @JsonProperty("var_end")
	private int varEnd;
	
	public Wind() {}

}
