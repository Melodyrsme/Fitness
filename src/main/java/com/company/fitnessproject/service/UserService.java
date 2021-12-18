package com.company.fitnessproject.service;

import com.company.fitnessproject.dto.ResponseUser;
import com.company.fitnessproject.dto.UserAuthDto;
import com.company.fitnessproject.dto.UserDto;

public interface UserService extends BaseService<ResponseUser, UserDto> {
    String getToken(UserAuthDto userAuthDto);
}
