package com.proyect.candoit.repository;

import com.proyect.candoit.enums.RoleEnum;
import com.proyect.candoit.model.Role;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RoleRepository extends JpaRepository<Role, Integer> {

    Role findByType(RoleEnum type);
}
