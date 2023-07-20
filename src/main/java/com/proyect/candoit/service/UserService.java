package com.proyect.candoit.service;

import com.proyect.candoit.dto.UserDto;
import com.proyect.candoit.model.User;

public interface UserService {

    void saveUser(UserDto userDto);
    void updateUser(Long userId, UserDto userDto);
    void removeUser(Long userId);
    User getUserByUsername(String username);
}
