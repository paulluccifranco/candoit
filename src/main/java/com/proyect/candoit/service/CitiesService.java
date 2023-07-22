package com.proyect.candoit.service;

import com.proyect.candoit.model.Cities;

public interface CitiesService {

    Cities getLastCitiesInfo();
    void save(Cities cities);
}
