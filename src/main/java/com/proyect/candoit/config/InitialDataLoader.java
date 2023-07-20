package com.proyect.candoit.config;

import com.proyect.candoit.enums.RoleEnum;
import com.proyect.candoit.model.Role;
import com.proyect.candoit.repository.RoleRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@RequiredArgsConstructor
public class InitialDataLoader implements CommandLineRunner {

    private final RoleRepository roleRepository;

    @Override
    public void run(String... args) throws Exception {
        if (roleRepository.count() == 0) {
            roleRepository.saveAll(List.of(new Role(RoleEnum.ADMIN.getDescription(), RoleEnum.ADMIN),
                    new Role(RoleEnum.CONSULTANT.getDescription(), RoleEnum.CONSULTANT)));
        }
    }
}