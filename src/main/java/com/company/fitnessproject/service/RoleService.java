package com.company.fitnessproject.service;

import com.company.fitnessproject.entity.Role;

import java.util.List;

public interface RoleService {
    Role save(Role role);

    List<Role> getAll();

    Role findById(Long id);

    Role deleteById(Long id);
}
