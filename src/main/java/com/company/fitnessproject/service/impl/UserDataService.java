package com.company.fitnessproject.service.impl;

import com.company.fitnessproject.converter.UserDataConverter;
import com.company.fitnessproject.dto.ResponseUserData;
import com.company.fitnessproject.dto.UserDataDto;
import com.company.fitnessproject.repository.UserDataRepository;
import com.company.fitnessproject.service.UserDateService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class UserDataService implements UserDateService {
    final UserDataRepository userDataRepository;
    final UserDataConverter userDataConverter;

    @Override
    public ResponseUserData save(UserDataDto userDataDto) {
        return userDataConverter.toResponseDto(userDataRepository.save(userDataConverter.toEntity(userDataDto)));
    }

    @Override
    public List<ResponseUserData> getAll() {
        return userDataConverter.toResponsesDto(userDataRepository.findAll());
    }

    @Override
    public ResponseUserData findById(Long id) {
        return userDataConverter.toResponseDto(userDataRepository.findById(id).get());
    }

    @Override
    public ResponseUserData deleteById(Long id) {
        return null;
    }
}
