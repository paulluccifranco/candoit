package com.proyect.candoit.task;

import com.proyect.candoit.model.Cities;
import com.proyect.candoit.service.ApiConsumer;
import com.proyect.candoit.service.CitiesService;
import lombok.RequiredArgsConstructor;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.util.Date;

@Component
@EnableScheduling
@RequiredArgsConstructor
public class RecoverWeatherData {

    private final ApiConsumer apiConsumer;
    private final CitiesService citiesService;

    @Scheduled(cron = "0 0/5 * * * ?")
    public void ejecutarTarea() {
        Cities cities = new Cities();
        cities.setCityList(apiConsumer.getData());
        cities.setDate(new Date());
        citiesService.save(cities);
        System.out.println("Se actualizaron los datos del clima");
    }
}
