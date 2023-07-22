package com.proyect.candoit.controller;

import com.proyect.candoit.dto.UserDto;
import com.proyect.candoit.mapper.UserMapper;
import com.proyect.candoit.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequiredArgsConstructor
@RequestMapping("/users")
public class UserController {

    private final UserService userService;

    @GetMapping("")
    public String usersPage(Model model) {
        List<UserDto> users = userService.getAllUsers().stream().map(UserMapper::mapToUserDto).toList();
        model.addAttribute("users", users);
        return "users";
    }

    @GetMapping("/new")
    public String createUserPage(Model model) {
        model.addAttribute("user", new UserDto());
        return "newuser";
    }

    @GetMapping("/{id}")
    public String editUserPage(@PathVariable Long id, Model model) {
        UserDto userDto = UserMapper.mapToUserDto(userService.getUserById(id));
        model.addAttribute("user", userDto);
        return "edituser";
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteUser(@PathVariable Long id) {
        userService.removeUser(id);
        return ResponseEntity.ok("");
    }

    @PostMapping("")
    public ResponseEntity<String> saveUser(@ModelAttribute UserDto userDto){
        try {
            userService.saveUser(userDto);
        }catch(Exception e) {
            return ResponseEntity.badRequest().build();
        }
        return ResponseEntity.ok("");
    }

    @PutMapping("")
    public ResponseEntity<String> editUser(@ModelAttribute UserDto userDto) {
        userService.updateUser(userDto);
        return ResponseEntity.ok("");
    }
}
