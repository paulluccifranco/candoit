package com.proyect.candoit.service;

import com.proyect.candoit.dto.UserDto;
import com.proyect.candoit.model.User;
import com.proyect.candoit.repository.RoleRepository;
import com.proyect.candoit.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService{

    private final UserRepository userRepository;
    private final RoleRepository roleRepository;
    private final BCryptPasswordEncoder passwordEncoder;

    @Override
    public void saveUser(UserDto userDto) {
        User user = new User();
        user.setUsername(userDto.getUsername());
        user.setPassword(passwordEncoder.encode(userDto.getPassword()));
        user.setRole(roleRepository.getReferenceById(userDto.getRoleId()));
        userRepository.save(user);

    }

    @Override
    public void updateUser(Long userId, UserDto userDto) {
        User user = new User();
        user.setId(userId);
        user.setPassword(passwordEncoder.encode(userDto.getPassword()));
        user.setRole(roleRepository.getReferenceById(userDto.getRoleId()));
        userRepository.save(user);
    }

    @Override
    public void removeUser(Long userId) {
        userRepository.deleteById(userId);
    }

    @Override
    public User getUserByUsername(String username) {
        return userRepository.findByUsername(username).get();
    }
}
