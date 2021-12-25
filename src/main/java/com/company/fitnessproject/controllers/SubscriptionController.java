package com.company.fitnessproject.controllers;

import com.company.fitnessproject.dto.CheckCountSubDto;
import com.company.fitnessproject.dto.ResponseSubscription;
import com.company.fitnessproject.dto.ResponseUserData;
import com.company.fitnessproject.dto.SubscriptionDto;
import com.company.fitnessproject.repository.SubscriptionRepository;
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

    @GetMapping("/{id}")
    public ResponseSubscription findById(@PathVariable Long id){
        return subscriptionService.findById(id);
    }

}
