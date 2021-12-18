package com.company.fitnessproject.controllers;

import com.company.fitnessproject.dto.GymDto;
import com.company.fitnessproject.dto.ResponseGym;
import com.company.fitnessproject.service.GymService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/gym")
@RequiredArgsConstructor
public class GymController {
    private final GymService gymService;

    @PostMapping
    public ResponseGym save(@RequestBody GymDto gymDto) {
        return gymService.save(gymDto);
    }

    @GetMapping
    public List<ResponseGym> getAll() {
        return gymService.getAll();
    }

    @GetMapping("/{id}")
    public ResponseGym getById(@PathVariable Long id) {
        return gymService.findById(id);
    }
}
