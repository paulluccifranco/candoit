package com.proyect.candoit.service;

import com.proyect.candoit.model.City;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;
import java.util.List;

@Service
public class ApiConsumerServiceImpl implements ApiConsumerService {

    @Override
    public List<City> getData() {
        WebClient webClient = WebClient.create();

        WebClient.ResponseSpec responseSpec = webClient.get()
                .uri(API_PATH)
                .retrieve();
        return responseSpec.bodyToFlux(City.class)
                .collectList()
                .block();
    }
}
