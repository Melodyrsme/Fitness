package com.company.fitnessproject.converter;

import com.company.fitnessproject.dto.ResponseSubscription;
import com.company.fitnessproject.dto.SubscriptionDto;
import com.company.fitnessproject.entity.Subscription;
import com.company.fitnessproject.enums.TypeMode;
import com.company.fitnessproject.enums.TypeSubscription;
import com.company.fitnessproject.repository.GymRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
@RequiredArgsConstructor
public class SubscriptionConverter {
    private final GymRepository gymRepository;
    private final GymConverter gymConverter;

    public Subscription toEntity(SubscriptionDto subscriptionDto) {
        TypeSubscription typeSubscription;
        TypeMode typeMode;
        if (TypeSubscription.ONE_MONTH_SUB.ordinal() == subscriptionDto.getTypeSubscriptionId()) {
            typeSubscription = TypeSubscription.ONE_MONTH_SUB;
        } else if (TypeSubscription.THREE_MONTH_SUB.ordinal() == subscriptionDto.getTypeSubscriptionId())
            typeSubscription = TypeSubscription.THREE_MONTH_SUB;
        else if (TypeSubscription.SIX_MONTH_SUB.ordinal() == subscriptionDto.getTypeSubscriptionId())
            typeSubscription = TypeSubscription.SIX_MONTH_SUB;
        else typeSubscription = TypeSubscription.YEAR_SUB;

        if (TypeMode.AFTERNOON.ordinal() == subscriptionDto.getTypeModId())
            typeMode = TypeMode.AFTERNOON;
        else typeMode = TypeMode.EVENING;

        return Subscription.builder()
                .gym(gymRepository.findById(subscriptionDto.getGymId()).get())
                .typeSubscription(typeSubscription)
                .typeMode(typeMode)
                .description(subscriptionDto.getDescription())
                .price(subscriptionDto.getPrice())
                .hasCoach(subscriptionDto.isHasCoach())
                .build();
    }

    public ResponseSubscription toResponseDto(Subscription subscription) {
        return ResponseSubscription.builder()
                .responseGym(gymConverter.toResponseDto(subscription.getGym()))
                .typeSubscription(subscription.getTypeSubscription())
                .typeMode(subscription.getTypeMode())
                .description(subscription.getDescription())
                .price(subscription.getPrice())
                .hasCoach(subscription.isHasCoach())
                .build();
    }

    public List<ResponseSubscription> toResponsesDto(List<Subscription> subscriptions) {
        List<ResponseSubscription> responseSubscription = new ArrayList<>();
        for (Subscription subscription : subscriptions) {
            responseSubscription.add(ResponseSubscription.builder()
                    .responseGym(gymConverter.toResponseDto(subscription.getGym()))
                    .typeSubscription(subscription.getTypeSubscription())
                    .typeMode(subscription.getTypeMode())
                    .description(subscription.getDescription())
                    .price(subscription.getPrice())
                    .hasCoach(subscription.isHasCoach())
                    .build());
        }
        return responseSubscription;
    }
}
