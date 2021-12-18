package com.company.fitnessproject.service.impl;

import com.company.fitnessproject.entity.Subscription;
import com.company.fitnessproject.enums.TypeMode;
import com.company.fitnessproject.enums.TypeSubscription;
import com.company.fitnessproject.repository.SubscriptioRepository;
import com.company.fitnessproject.service.SubscriptionService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class SubscriptionServiceImpl implements SubscriptionService {
    final SubscriptioRepository subscriptionRepository;

    @Override
    public Subscription save(Subscription subscription) {
        return subscriptionRepository.save(subscription);
    }

    @Override
    public List<Subscription> getByTypeMode(TypeMode typeMode) {
        Subscription subscription = null;
        if(subscription.getTypeMode().equals(typeMode)){
            return subscriptionRepository.findAll();
        }
        else
            return null;
    }

    @Override
    public List<Subscription> getByTypeSubscription(TypeSubscription typeSubscription) {
        Subscription subscription = null;
        if(subscription.getTypeSubscription().equals(typeSubscription)){
            return subscriptionRepository.findAll();
        }
        else
            return null;
    }

    @Override
    public List<Subscription> getAll() {
        return subscriptionRepository.findAll();
    }

    @Override
    public Subscription findById(Long id) {
        return subscriptionRepository.findById(id).get();
    }

    @Override
    public Subscription deleteById(Long id) {
        Subscription subscription = findById(id);
        if(subscription != null)
            subscriptionRepository.deleteById(id);
        return subscription;
    }
}
