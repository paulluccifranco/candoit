package com.proyect.candoit.security;

import com.proyect.candoit.model.Role;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.GrantedAuthority;

@RequiredArgsConstructor
public class UserPermission implements GrantedAuthority {

    private final transient Role role;

    @Override
    public String getAuthority() {
        return role.getType().name();
    }
}
