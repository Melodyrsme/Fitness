package com.company.fitnessproject.service.impl;

import com.company.fitnessproject.converter.SubscriptionConverter;
import com.company.fitnessproject.dto.CheckCountSubDto;
import com.company.fitnessproject.dto.ResponseSubscription;
import com.company.fitnessproject.dto.SubscriptionDto;
import com.company.fitnessproject.entity.Subscription;
import com.company.fitnessproject.enums.TypeSubscription;
import com.company.fitnessproject.repository.SubscriptionRepository;
import com.company.fitnessproject.service.SubscriptionService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.math.BigDecimal;
import java.util.List;

@Service
@RequiredArgsConstructor
public class SubscriptionServiceImpl implements SubscriptionService {
    private final SubscriptionRepository subscriptionRepository;
    private final SubscriptionConverter subscriptionConverter;

    @Override
    public ResponseSubscription save(SubscriptionDto subscriptionDto) {
        Subscription subscription = discounts(subscriptionDto);

        if (subscriptionDto.getPriceCoach() != null) {
            subscription.setPrice(subscriptionDto.getPrice().add(BigDecimal.valueOf(5000L)));
            subscription.setHasCoach(true);
        }
        return subscriptionConverter.toResponseDto(subscriptionRepository.save(subscription));
    }

    private Subscription discounts(SubscriptionDto subscriptionDto) {
        String discountDescription = "";
        BigDecimal discountPrice = subscriptionDto.getPrice();
        Long counter = null;

        if (subscriptionDto.getTypeSubscriptionId() == TypeSubscription.ONE_MONTH_SUB.ordinal()) {
            discountDescription = "Абонемент на месяц";
            discountPrice = (subscriptionDto.getPrice().multiply(BigDecimal.valueOf(1L)).subtract(discountPrice.multiply(BigDecimal.valueOf(subscriptionDto.getTypeSubscriptionId()))));
            counter = 12L;
        } else if (subscriptionDto.getTypeSubscriptionId() == TypeSubscription.THREE_MONTH_SUB.ordinal()) {
            discountDescription = "Абонемент на три месяца";
            discountPrice = (subscriptionDto.getPrice().multiply(BigDecimal.valueOf(3L)).subtract(discountPrice.multiply(BigDecimal.valueOf(subscriptionDto.getTypeSubscriptionId()))));
            counter = 36L;
        } else if (subscriptionDto.getTypeSubscriptionId() == TypeSubscription.SIX_MONTH_SUB.ordinal()) {
            discountDescription = "Абонемент на полгода";
            discountPrice = (subscriptionDto.getPrice().multiply(BigDecimal.valueOf(6L)).subtract(discountPrice.multiply(BigDecimal.valueOf(subscriptionDto.getTypeSubscriptionId()))));
            counter = 72L;
        } else if (subscriptionDto.getTypeSubscriptionId() == TypeSubscription.YEAR_SUB.ordinal()) {
            discountDescription = "Абонемент на год";
            discountPrice = (subscriptionDto.getPrice().multiply(BigDecimal.valueOf(12L)).subtract(discountPrice.multiply(BigDecimal.valueOf(subscriptionDto.getTypeSubscriptionId()))));
            counter = 144L;
        }

        Subscription subscription = subscriptionConverter.toEntity(subscriptionDto);
        subscription.setCount(counter);
        subscription.setDescription(discountDescription);
        subscription.setPrice(discountPrice);

        return subscription;
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
