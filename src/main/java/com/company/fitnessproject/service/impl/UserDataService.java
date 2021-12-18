package com.company.fitnessproject.service.impl;

import com.company.fitnessproject.entity.Subscription;
import com.company.fitnessproject.entity.UserData;
import com.company.fitnessproject.repository.UserDataRepository;
import com.company.fitnessproject.service.UserDateService;
import com.company.fitnessproject.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class UserDataService implements UserDateService {
    final UserDataRepository userDataRepository;
    final UserService userService;

    @Override
    public UserData save(UserData userData) {
        return userDataRepository.save(userData);
    }

    @Override
    public UserData saveSub(Subscription subscription) {
        UserData userData = new UserData();
        userData.setSubscription(subscription);
        userData.setId(userDataRepository.getByUserData(SecurityContextHolder.getContext().getAuthentication().getName()));
        return userDataRepository.save(userData);
    }

    @Override
    public List<UserData> getAll() {
        return userDataRepository.findAll();
    }

    @Override
    public UserData findById(Long id) {
        return userDataRepository.findById(id).get();
    }

    @Override
    public UserData deleteById(Long id) {
        UserData userData = findById(id);
        if (userData != null) {
            userDataRepository.deleteById(id);
        }
        return userData;
    }
}
