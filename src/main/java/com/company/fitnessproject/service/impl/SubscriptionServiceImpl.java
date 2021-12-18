package com.company.fitnessproject.service.impl;

import com.company.fitnessproject.converter.SubscriptionConverter;
import com.company.fitnessproject.dto.ResponseSubscription;
import com.company.fitnessproject.dto.SubscriptionDto;
import com.company.fitnessproject.repository.SubscriptionRepository;
import com.company.fitnessproject.service.SubscriptionService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class SubscriptionServiceImpl implements SubscriptionService {
    private final SubscriptionRepository subscriptionRepository;
    private final SubscriptionConverter subscriptionConverter;

    @Override
    public ResponseSubscription save(SubscriptionDto subscriptionDto) {
        return subscriptionConverter.toResponseDto(subscriptionRepository.save(subscriptionConverter.toEntity(subscriptionDto)));
    }

    @Override
    public List<ResponseSubscription> getAll() {
        return subscriptionConverter.toResponsesDto(subscriptionRepository.findAll());
    }

    @Override
    public ResponseSubscription findById(Long id) {
        return subscriptionConverter.toResponseDto(subscriptionRepository.findById(id).get());
    }

    @Override
    public ResponseSubscription deleteById(Long id) {
        return null;
    }
}
