package com.proyect.candoit.service;

import com.proyect.candoit.dto.UserDto;
import com.proyect.candoit.model.User;
import org.springframework.dao.DuplicateKeyException;

import java.util.List;

public interface UserService {

    List<User> getAllUsers();
    void saveUser(UserDto userDto) throws DuplicateKeyException;
    void updateUser(UserDto userDto);
    void removeUser(Long userId);
    User getUserByUsername(String username);
    User getUserById(Long id);
}
