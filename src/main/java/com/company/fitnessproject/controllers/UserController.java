package com.company.fitnessproject.controllers;

import com.company.fitnessproject.dto.ResponseUser;
import com.company.fitnessproject.dto.UserAuthDto;
import com.company.fitnessproject.dto.UserDto;
import com.company.fitnessproject.service.UserService;

import lombok.RequiredArgsConstructor;

import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/user")
@RequiredArgsConstructor
public class UserController {
    private final UserService userService;

    @PostMapping
    public ResponseUser saveUser(@RequestBody UserDto userDto) {
        return userService.save(userDto);
    }

    @PostMapping("/get-token")
    public String getToken(UserAuthDto userAuthDto) {
        return userService.getToken(userAuthDto);
    }

    @GetMapping
    public List<ResponseUser> getAll() {
        return userService.getAll();
    }
}
