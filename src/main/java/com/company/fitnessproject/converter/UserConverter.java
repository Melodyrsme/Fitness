package com.company.fitnessproject.converter;

import com.company.fitnessproject.dto.UserDto;
import com.company.fitnessproject.entity.User;
import org.springframework.stereotype.Component;

@Component
public class UserConverter {
    User toEntity(UserDto userDto){
        return User.builder()
                .login(userDto.getLogin())
                .password(userDto.getPassword())
                .build();
    }
}
