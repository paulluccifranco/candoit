package com.proyect.candoit.service;

import com.proyect.candoit.model.Cities;
import com.proyect.candoit.model.City;
import lombok.RequiredArgsConstructor;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.reactive.function.client.WebClient;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ApiConsumer {

    public List<City> getData() {
        WebClient webClient = WebClient.create();

        WebClient.ResponseSpec responseSpec = webClient.get()
                .uri("https://ws.smn.gob.ar/map_items/weather")
                .retrieve();
        List<City> cities = responseSpec.bodyToFlux(City.class)
                .collectList()
                .block();

        return cities;
    }
}
