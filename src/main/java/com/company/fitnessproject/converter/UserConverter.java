package com.company.fitnessproject.converter;

import com.company.fitnessproject.dto.ResponseUser;
import com.company.fitnessproject.dto.UserDto;
import com.company.fitnessproject.entity.User;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class UserConverter {
    public User toEntity(UserDto userDto) {
        return User.builder()
                .login(userDto.getLogin())
                .password(userDto.getPassword())
                .build();
    }

    public ResponseUser toResponseDto(User user) {
        return ResponseUser.builder()
                .id(user.getId())
                .login(user.getLogin())
                .build();
    }

    public List<ResponseUser> toResponsesDto(List<User> users) {
        List<ResponseUser> responseUsers = new ArrayList<>();
        for (User user : users) {
            responseUsers.add(ResponseUser.builder()
                    .id(user.getId())
                    .login(user.getLogin())
                    .build());
        }
        return responseUsers;
    }
}
