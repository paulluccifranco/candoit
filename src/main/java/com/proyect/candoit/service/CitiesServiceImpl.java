package com.proyect.candoit.service;

import com.proyect.candoit.model.Cities;
import com.proyect.candoit.repository.CitiesRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class CitiesServiceImpl implements CitiesService{

    private final CitiesRepository citiesRepository;

    @Override
    public Cities getLastCitiesInfo() {
        return citiesRepository.findFirstByOrderByDateDesc();
    }

    @Override
    public void save(Cities cities) {
        citiesRepository.save(cities);
    }
}
