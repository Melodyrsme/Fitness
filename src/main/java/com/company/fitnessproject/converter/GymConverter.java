package com.company.fitnessproject.converter;

import com.company.fitnessproject.dto.GymDto;
import com.company.fitnessproject.dto.ResponseGym;
import com.company.fitnessproject.entity.Gym;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class GymConverter {
    public Gym toEntity(GymDto gymDto) {
        return Gym.builder()
                .description(gymDto.getDescription())
                .address(gymDto.getAddress())
                .build();
    }

    public Gym toEntity(ResponseGym responseGym) {
        return Gym.builder()
                .description(responseGym.getDescription())
                .address(responseGym.getAddress())
                .build();
    }

    public ResponseGym toResponseDto(Gym gym) {
        return ResponseGym.builder()
                .id(gym.getId())
                .description(gym.getDescription())
                .address(gym.getAddress())
                .build();
    }

    public List<ResponseGym> toResponsesDto(List<Gym> gyms) {
        List<ResponseGym> responseUsers = new ArrayList<>();
        for (Gym gym : gyms) {
            responseUsers.add(ResponseGym.builder()
                    .id(gym.getId())
                    .description(gym.getDescription())
                    .address(gym.getAddress())
                    .build());
        }
        return responseUsers;
    }
}
