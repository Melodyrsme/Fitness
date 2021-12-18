package com.company.fitnessproject.service;

import com.company.fitnessproject.entity.Subscription;
import com.company.fitnessproject.entity.UserData;

import java.util.List;

public interface UserDateService {
    UserData save(UserData userData);

    UserData saveSub(Subscription subscription);

    List<UserData> getAll();

    UserData findById(Long id);

    UserData deleteById(Long id);
}
