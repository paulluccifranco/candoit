package com.proyect.candoit.service;

import com.proyect.candoit.model.City;
import java.util.List;

public interface ApiConsumerService {

    String API_PATH = "https://ws.smn.gob.ar/map_items/weather";
    List<City> getData();
}
