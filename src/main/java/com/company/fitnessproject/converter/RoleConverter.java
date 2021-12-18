package com.company.fitnessproject.converter;

import com.company.fitnessproject.dto.ResponseRole;
import com.company.fitnessproject.dto.RoleDto;
import com.company.fitnessproject.entity.Role;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class RoleConverter {
    public Role toEntity(RoleDto roleDto) {
        return Role.builder()
                .nameRole(roleDto.getName())
                .build();
    }

    public ResponseRole toResponseDto(Role role) {
        return ResponseRole.builder()
                .id(role.getId())
                .name(role.getNameRole())
                .build();
    }

    public List<ResponseRole> toResponsesDto(List<Role> roles) {
        List<ResponseRole> responseUsers = new ArrayList<>();
        for (Role role : roles) {
            responseUsers.add(ResponseRole.builder()
                    .id(role.getId())
                    .name(role.getNameRole())
                    .build());
        }
        return responseUsers;
    }
}
