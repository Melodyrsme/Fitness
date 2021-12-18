package com.company.fitnessproject.controllers;

import com.company.fitnessproject.entity.User;
import com.company.fitnessproject.entity.UserData;
import com.company.fitnessproject.service.impl.UserDataService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/user_data")
@RequiredArgsConstructor
public class UserDataController {
    final UserDataService userDataService;

    @PostMapping
    public UserData save(@RequestBody UserData userData) {
        return userDataService.save(userData);
    }

    @GetMapping
    public List<UserData> getAll() {
        return userDataService.getAll();
    }

    @GetMapping("/{id}")
    public UserData findById(@PathVariable Long id) {
        return userDataService.findById(id);
    }

    @DeleteMapping("/{id}")
    public UserData deleteById(@PathVariable Long id) {
        UserData userData = findById(id);
        if (userData != null) {
            userDataService.deleteById(id);
        }
        return userData;
    }
}
