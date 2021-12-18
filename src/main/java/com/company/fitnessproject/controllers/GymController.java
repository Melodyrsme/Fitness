package com.company.fitnessproject.controllers;

import com.company.fitnessproject.entity.Gym;
import com.company.fitnessproject.service.GymService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/gym")
@RequiredArgsConstructor
public class GymController {
    final GymService gymService;

    @PostMapping
    public Gym save(@RequestBody Gym gym){
        return gymService.save(gym);
    }

    @GetMapping
    public List<Gym> getAll() {
        return gymService.getAll();
    }

    @GetMapping("/{id}")
    public Gym getById(@PathVariable Long id) {
        return gymService.getById(id);
    }
}
