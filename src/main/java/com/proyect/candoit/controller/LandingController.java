package com.proyect.candoit.controller;

import com.proyect.candoit.model.Cities;
import com.proyect.candoit.service.CitiesService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
@RequiredArgsConstructor
public class LandingController {

    private final CitiesService citiesService;

    @GetMapping("/index")
    public String loginPage(Model model, Authentication authentication) {
        Cities cities = citiesService.getLastCitiesInfo();
        model.addAttribute("cities", cities);
        return "index";
    }
}
