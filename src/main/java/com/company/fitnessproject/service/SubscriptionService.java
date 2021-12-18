package com.company.fitnessproject.service;

import com.company.fitnessproject.entity.Subscription;
import com.company.fitnessproject.enums.TypeMode;
import com.company.fitnessproject.enums.TypeSubscription;

import java.util.List;

public interface SubscriptionService {
    Subscription save(Subscription subscription);

    List<Subscription> getByTypeMode(TypeMode typeMode);

    List<Subscription> getByTypeSubscription(TypeSubscription typeSubscription);

    List<Subscription> getAll();

    Subscription findById(Long id);

    Subscription deleteById(Long id);
}
