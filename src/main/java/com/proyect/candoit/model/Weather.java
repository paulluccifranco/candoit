package com.proyect.candoit.model;

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
    private BigDecimal wind_speed;
    private Integer id;
    private String description;
    private BigDecimal temp;
    private String wing_deg;
    private String tempDesc;


}
