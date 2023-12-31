package com.proyect.candoit.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;

@NoArgsConstructor
@Getter
@Setter
public class City {

    private BigDecimal dist;
    private Integer lid;
    private Integer fid;
    @JsonProperty("int_number")
    private Integer intNumber;
    private String name;
    private String province;
    private BigDecimal lat;
    private BigDecimal lon;
    private Integer zoom;
    private Integer updated;
    private Weather weather;

}
