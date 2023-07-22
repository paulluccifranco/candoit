package com.proyect.candoit.loader;

import com.proyect.candoit.enums.RoleEnum;
import com.proyect.candoit.model.Cities;
import com.proyect.candoit.model.Role;
import com.proyect.candoit.model.User;
import com.proyect.candoit.repository.CitiesRepository;
import com.proyect.candoit.repository.RoleRepository;
import com.proyect.candoit.repository.UserRepository;
import com.proyect.candoit.service.ApiConsumerService;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Component;

import java.util.Date;
import java.util.List;

@Component
@RequiredArgsConstructor
public class InitialDataLoader implements CommandLineRunner {

    private final RoleRepository roleRepository;
    private final UserRepository userRepository;
    private final CitiesRepository citiesRepository;
    private final BCryptPasswordEncoder passwordEncoder;
    private final ApiConsumerService apiConsumerService;

    @Override
    public void run(String... args) throws Exception {
        if (roleRepository.count() == 0) {
            roleRepository.saveAll(List.of(new Role(RoleEnum.ADMIN.getDescription(), RoleEnum.ADMIN),
                    new Role(RoleEnum.CONSULTANT.getDescription(), RoleEnum.CONSULTANT)));
            User user = new User();
            user.setRole(roleRepository.findByType(RoleEnum.ADMIN));
            user.setUsername("franco");
            user.setPassword(passwordEncoder.encode("123456"));
            userRepository.save(user);
        }
        Cities cities = new Cities();
        cities.setCityList(apiConsumerService.getData());
        cities.setDate(new Date());
        citiesRepository.save(cities);
    }
}