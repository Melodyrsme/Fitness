package com.company.fitnessproject.service;

import com.company.fitnessproject.entity.Gym;
import com.company.fitnessproject.repository.GymRepository;
import org.springframework.stereotype.Service;

import java.util.List;

public interface GymService {
    Gym save(Gym gym);

    List<Gym> getAll();

    Gym getById(Long id);
}