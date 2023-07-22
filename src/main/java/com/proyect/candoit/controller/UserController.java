package com.proyect.candoit.controller;

import com.proyect.candoit.dto.UserDto;
import com.proyect.candoit.mapper.UserMapper;
import com.proyect.candoit.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.dao.DuplicateKeyException;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;
import java.util.stream.Collectors;

@Controller
@RequiredArgsConstructor

public class UserController {

    private final UserService userService;

    @GetMapping("/users")
    public String usersPage(Model model) {
        List<UserDto> users = userService.getAllUsers().stream().map(UserMapper::mapToUserDto).collect(Collectors.toList());
        model.addAttribute("users", users);
        return "users";
    }

    @GetMapping("/users/new")
    public String createUserPage(Model model) {
        model.addAttribute("user", new UserDto());
        return "newuser";
    }

    @GetMapping("/users/{id}")
    public String editUserPage(@PathVariable Long id, Model model) {
        UserDto userDto = UserMapper.mapToUserDto(userService.getUserById(id));
        model.addAttribute("user", userDto);
        return "edituser";
    }

    @DeleteMapping("/users/{id}")
    public ResponseEntity deleteUser(@PathVariable Long id) {
        userService.removeUser(id);
        return ResponseEntity.ok("");
    }

    @PostMapping("/users")
    public ResponseEntity saveUser(@ModelAttribute UserDto userDto, Model model){
        try {
            userService.saveUser(userDto);
        }catch(Exception e) {
            return ResponseEntity.badRequest().build();
        }
        return ResponseEntity.ok("");
    }

    @PutMapping("/users")
    public ResponseEntity editUser(@ModelAttribute UserDto userDto, Model model) {
        userService.updateUser(userDto);
        return ResponseEntity.ok("");
    }
}
