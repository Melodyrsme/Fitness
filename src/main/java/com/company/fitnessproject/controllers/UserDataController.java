package com.company.fitnessproject.controllers;

import com.company.fitnessproject.dto.ResponseUserData;
import com.company.fitnessproject.dto.UserDataDto;
import com.company.fitnessproject.service.impl.UserDataService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/user-data")
@RequiredArgsConstructor
public class UserDataController {
    private final UserDataService userDataService;

    @PostMapping
    public ResponseUserData save(@RequestBody UserDataDto userDataDto) {
        return userDataService.save(userDataDto);
    }

    @GetMapping
    public List<ResponseUserData> getAll() {
        return userDataService.getAll();
    }

    @GetMapping("/{id}")
    public ResponseUserData findById(@PathVariable Long id) {
        return userDataService.findById(id);
    }

    @DeleteMapping("/{id}")
    public ResponseUserData deleteById(@PathVariable Long id) {
        return null;
    }
}
