package com.proyect.candoit.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;

@NoArgsConstructor
@Getter
@Setter
public class Weather {

    private BigDecimal humidity;
    private BigDecimal pressure;
    private BigDecimal st;
    private BigDecimal visibility;
    @JsonProperty("wind_speed")
    private BigDecimal windSpeed;
    private Integer id;
    private String description;
    private BigDecimal temp;
    @JsonProperty("wing_deg")
    private String wingDeg;
    private String tempDesc;


}
