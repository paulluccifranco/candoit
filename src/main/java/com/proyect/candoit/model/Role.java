package com.proyect.candoit.model;

import com.proyect.candoit.enums.RoleEnum;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;

@Entity
@Table(name="ROLES")
@Getter
@Setter
@NoArgsConstructor
public class Role implements Serializable {

    public Role(String description, RoleEnum type) {
        this.description = description;
        this.type = type;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="ID")
    private int id;
    @Column(name = "DESCRIPTION")
    private String description;
    @Column(name = "TYPE")
    @Enumerated(EnumType.STRING)
    private RoleEnum type;
}
