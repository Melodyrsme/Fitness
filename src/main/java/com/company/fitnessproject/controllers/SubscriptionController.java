package com.company.fitnessproject.controllers;

import com.company.fitnessproject.dto.ResponseSubscription;
import com.company.fitnessproject.dto.SubscriptionDto;
import com.company.fitnessproject.entity.Subscription;
import com.company.fitnessproject.service.SubscriptionService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/subscription")
@RequiredArgsConstructor
public class SubscriptionController {
    private final SubscriptionService subscriptionService;

    @PostMapping
    public ResponseSubscription save(@RequestBody SubscriptionDto subscriptionDto) {
        return subscriptionService.save(subscriptionDto);
    }

    @GetMapping
    public List<ResponseSubscription> getAll() {
        return subscriptionService.getAll();
    }

    @PostMapping("/{id}")
    public ResponseSubscription findById(Long id) {
        return subscriptionService.findById(id);
    }

    @DeleteMapping("/{id}")
    public Subscription deleteById(Long id) {
        return null;
    }

}
