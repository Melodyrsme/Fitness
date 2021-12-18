package com.company.fitnessproject.service.impl;

import com.company.fitnessproject.entity.User;
import com.company.fitnessproject.entity.UserRoles;
import com.company.fitnessproject.repository.UserRepository;
import com.company.fitnessproject.repository.UserRolesRepository;
import com.company.fitnessproject.service.RoleService;
import com.company.fitnessproject.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {
    final UserRepository userRepository;
    final RoleService roleService;
    final UserRolesRepository userRolesRepository;
    final PasswordEncoder passwordEncoder;

    @Override
    public User save(User user) {
        UserRoles userRoles = new UserRoles();
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        user.setIsActive(1L);
        userRoles.setUser(userRepository.save(user));
        userRoles.setRole(roleService.findById(1L));
        userRolesRepository.save(userRoles);
        return user;
    }

    @Override
    public List<User> getAll() {
        return userRepository.findAll();
    }

    @Override
    public User findById(Long id) {
        return userRepository.getById(id);
    }

    @Override
    public User deleteById(Long id) {
        return null;
    }

    @Override
    public String getToken(User user) {
        User user = userRepository.findByLogin(user.getLogin())
        return
    }
}
