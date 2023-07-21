package com.proyect.candoit.controller;

import com.proyect.candoit.dto.UserDto;
import com.proyect.candoit.mapper.UserMapper;
import com.proyect.candoit.model.Cities;
import com.proyect.candoit.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;
import java.util.stream.Collectors;

@Controller
@RequiredArgsConstructor
public class UserController {

    private final UserService userService;

    @GetMapping("/users")
    public String usersPage(Model model, Authentication authentication) {
        List<UserDto> users = userService.getAllUsers().stream().map(UserMapper::mapUser).collect(Collectors.toList());
        model.addAttribute("users", users);
        return "users";
    }
}
