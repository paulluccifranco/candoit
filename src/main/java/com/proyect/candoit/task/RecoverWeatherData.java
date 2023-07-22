package com.proyect.candoit.task;

import com.proyect.candoit.model.Cities;
import com.proyect.candoit.service.ApiConsumerService;
import com.proyect.candoit.service.CitiesService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.util.Date;

@Component
@EnableScheduling
@RequiredArgsConstructor
@Slf4j
public class RecoverWeatherData {

    private final ApiConsumerService apiConsumerService;
    private final CitiesService citiesService;

    @Scheduled(cron = "0 0/5 * * * ?")
    public void ejecutarTarea() {
        Cities cities = new Cities();
        cities.setCityList(apiConsumerService.getData());
        cities.setDate(new Date());
        citiesService.save(cities);
        log.info("Se actualizaron los datos del clima");
    }
}
