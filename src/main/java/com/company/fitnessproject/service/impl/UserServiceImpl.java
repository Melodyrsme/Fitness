package com.company.fitnessproject.service.impl;

import com.company.fitnessproject.converter.UserConverter;
import com.company.fitnessproject.dto.ResponseUser;
import com.company.fitnessproject.dto.UserAuthDto;
import com.company.fitnessproject.dto.UserDto;
import com.company.fitnessproject.entity.User;
import com.company.fitnessproject.entity.UserRoles;
import com.company.fitnessproject.exception.UserCheckPassword;
import com.company.fitnessproject.repository.RoleRepository;
import com.company.fitnessproject.repository.UserRepository;
import com.company.fitnessproject.repository.UserRolesRepository;
import com.company.fitnessproject.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {
    final UserRepository userRepository;
    final RoleRepository roleRepository;
    final UserRolesRepository userRolesRepository;
    final PasswordEncoder passwordEncoder;
    final UserConverter userConverter;

    @Override
    public ResponseUser save(UserDto userDto) {
        UserRoles userRoles = new UserRoles();

        User user = userConverter.toEntity(userDto);
        user.setPassword(passwordEncoder.encode(userDto.getPassword()));
        user.setIsActive(1L);

        userRoles.setUser(userRepository.save(user));
        userRoles.setRole(roleRepository.findById(1L).get());
        userRolesRepository.save(userRoles);

        return userConverter.toResponseDto(user);
    }

    @Override
    public List<ResponseUser> getAll() {
        return userConverter.toResponsesDto(userRepository.findAll());
    }

    @Override
    public ResponseUser
    findById(Long id) {
        return userConverter.toResponseDto(userRepository.getById(id));
    }

    @Override
    public ResponseUser
    deleteById(Long id) {
        return null;
    }

    @Override
    public String getToken(UserAuthDto userAuthDto) {
        User user = userRepository.findByLogin(userAuthDto.getLogin());
        boolean isTrue = passwordEncoder.matches(userAuthDto.getPassword(), user.getPassword());
        if (isTrue) {
            return "Basic " + new String((userAuthDto.getLogin() + ":" + userAuthDto.getPassword()).getBytes());
        } else {
            throw new UserCheckPassword("Не верный логин или пароль.");
        }
    }
}
