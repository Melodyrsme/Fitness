package com.company.fitnessproject.service;

import com.company.fitnessproject.dto.UserAuthDto;
import com.company.fitnessproject.dto.UserDto;
import com.company.fitnessproject.entity.User;

public interface UserService extends BaseService<User, UserDto> {
    String getToken(UserAuthDto userAuthDto);
}
