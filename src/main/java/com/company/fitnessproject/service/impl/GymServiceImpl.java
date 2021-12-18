package com.company.fitnessproject.service.impl;

import com.company.fitnessproject.converter.GymConverter;
import com.company.fitnessproject.dto.GymDto;
import com.company.fitnessproject.dto.ResponseGym;
import com.company.fitnessproject.repository.GymRepository;
import com.company.fitnessproject.service.GymService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class GymServiceImpl implements GymService {
    final GymRepository gymRepository;
    final GymConverter gymConverter;

    @Override
    public ResponseGym save(GymDto gymDto) {
        return gymConverter.toResponseDto(gymRepository.save(gymConverter.toEntity(gymDto)));
    }

    @Override
    public List<ResponseGym> getAll() {
        return gymConverter.toResponsesDto(gymRepository.findAll());
    }

    @Override
    public ResponseGym findById(Long id) {
        return gymConverter.toResponseDto(gymRepository.findById(id).get());
    }

    @Override
    public ResponseGym deleteById(Long id) {
        return null;
    }
}
