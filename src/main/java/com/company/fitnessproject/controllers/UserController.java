package com.company.fitnessproject.controllers;

import com.company.fitnessproject.entity.User;
import com.company.fitnessproject.service.UserService;

import lombok.RequiredArgsConstructor;

import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/user")
@RequiredArgsConstructor
public class UserController {
    final UserService userService;

    @PostMapping
    public User saveUser(@RequestBody User user){
        return userService.save(user);
    }

    @GetMapping
    public List<User> getAll(){
        return userService.getAll();
    }
}
