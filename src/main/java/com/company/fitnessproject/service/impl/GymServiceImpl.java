package com.company.fitnessproject.service.impl;

import com.company.fitnessproject.entity.Gym;
import com.company.fitnessproject.repository.GymRepository;
import com.company.fitnessproject.service.GymService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class GymServiceImpl implements GymService {
    final GymRepository gymRepository;

    @Override
    public Gym save(Gym gym) {
        return gymRepository.save(gym);
    }

    @Override
    public List<Gym> getAll() {
        return gymRepository.findAll();
    }

    @Override
    public Gym getById(Long id) {
        return gymRepository.findById(id).get();
    }
}
