package com.company.fitnessproject.service.impl;

import com.company.fitnessproject.converter.RoleConverter;
import com.company.fitnessproject.dto.ResponseRole;
import com.company.fitnessproject.dto.RoleDto;
import com.company.fitnessproject.repository.RoleRepository;
import com.company.fitnessproject.service.RoleService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class RoleServiceImpl implements RoleService {
    private final RoleRepository roleRepository;
    private final RoleConverter roleConverter;

    @Override
    public ResponseRole save(RoleDto roleDto) {
        return roleConverter.toResponseDto(roleRepository.save(roleConverter.toEntity(roleDto)));
    }

    @Override
    public List<ResponseRole> getAll() {
        return roleConverter.toResponsesDto(roleRepository.findAll());
    }

    @Override
    public ResponseRole findById(Long id) {
        return roleConverter.toResponseDto(roleRepository.findById(id).get());
    }

    @Override
    public ResponseRole deleteById(Long id) {
        return null;
    }
}
