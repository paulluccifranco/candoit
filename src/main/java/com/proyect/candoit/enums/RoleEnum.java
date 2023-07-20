package com.proyect.candoit.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public enum RoleEnum {
    CONSULTANT("Rol para Consultores"), ADMIN("Rol para Administradores");

    private String description;
}
