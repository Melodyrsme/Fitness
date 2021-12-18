package com.company.fitnessproject.controllers;

import com.company.fitnessproject.entity.Subscription;
import com.company.fitnessproject.enums.TypeMode;
import com.company.fitnessproject.enums.TypeSubscription;
import com.company.fitnessproject.service.SubscriptionService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/subscription")
@RequiredArgsConstructor
public class SubscriptionController {
    final SubscriptionService subscriptionService;

    @PostMapping
    public Subscription save(@RequestBody Subscription subscription) {
        return subscriptionService.save(subscription);
    }

    @GetMapping("/{type-mode}")
    public List<Subscription> getByTypeMode(@PathVariable TypeMode typeMode) {
        Subscription subscription = null;
        if(subscription.getTypeMode().equals(typeMode)){
            return subscriptionService.getAll();
        }
        else
            return null;
    }

    @GetMapping("/{type-subscription}")
    public List<Subscription> getByTypeSubscription(@PathVariable TypeSubscription typeSubscription) {
        Subscription subscription = null;
        if(subscription.getTypeSubscription().equals(typeSubscription)){
            return subscriptionService.getAll();
        }
        else
            return null;
    }

    @GetMapping
    public List<Subscription> getAll() {
        return subscriptionService.getAll();
    }

    @PostMapping("/{id}")
    public Subscription findById(Long id) {
        return subscriptionService.findById(id);
    }

    @DeleteMapping("/{id}")
    public Subscription deleteById(Long id) {
        Subscription subscription = findById(id);
        if(subscription != null)
            subscriptionService.deleteById(id);
        return subscription;
    }

}
