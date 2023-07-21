package com.proyect.candoit.mapper;

import com.proyect.candoit.dto.UserDto;
import com.proyect.candoit.model.User;

public class UserMapper {

    public static UserDto mapUser(User user) {
        UserDto userDto = new UserDto();
        userDto.setId(user.getId());
        userDto.setUsername(user.getUsername());
        userDto.setRoleId(user.getRole().getId());
        return userDto;
    }
}
