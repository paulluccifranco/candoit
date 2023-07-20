package com.proyect.candoit.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.Date;
import java.util.List;

@Document(collection = "cities")
@NoArgsConstructor
@Getter
@Setter
public class Cities {
    @Id
    private String id;
    private List<City> cityList;
    private Date date;
}
