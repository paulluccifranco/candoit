package com.proyect.candoit.service;

import com.proyect.candoit.model.Cities;

import java.util.List;

public interface CitiesService {

    Cities getLastCitiesInfo();
    void save(Cities cities);
}
