package com.company.fitnessproject.converter;

import com.company.fitnessproject.dto.ResponseSubscription;
import com.company.fitnessproject.dto.SubscriptionDto;
import com.company.fitnessproject.entity.Subscription;
import com.company.fitnessproject.entity.User;
import com.company.fitnessproject.enums.TypeSubscription;
import com.company.fitnessproject.repository.GymRepository;
import com.company.fitnessproject.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
@RequiredArgsConstructor
public class SubscriptionConverter {
    private final GymRepository gymRepository;
    private final GymConverter gymConverter;
    private final UserRepository userRepository;
    private final UserConverter userConverter;

    public Subscription toEntity(SubscriptionDto subscriptionDto) {
        TypeSubscription typeSubscription;
        if (TypeSubscription.ONE_MONTH_SUB.ordinal() == subscriptionDto.getTypeSubscriptionId()) {
            typeSubscription = TypeSubscription.ONE_MONTH_SUB;
        } else if (TypeSubscription.THREE_MONTH_SUB.ordinal() == subscriptionDto.getTypeSubscriptionId())
            typeSubscription = TypeSubscription.THREE_MONTH_SUB;
        else if (TypeSubscription.SIX_MONTH_SUB.ordinal() == subscriptionDto.getTypeSubscriptionId())
            typeSubscription = TypeSubscription.SIX_MONTH_SUB;
        else typeSubscription = TypeSubscription.YEAR_SUB;

        return Subscription.builder()
                .user(userRepository.findById(subscriptionDto.getUserId()).get())
                .gym(gymRepository.findById(subscriptionDto.getGymId()).get())
                .typeSubscription(typeSubscription)
                .build();
    }

    public ResponseSubscription toResponseDto(Subscription subscription) {
        User user = userRepository.findByLogin(SecurityContextHolder.getContext().getAuthentication().getName());
        return ResponseSubscription.builder()
                .responseUser(userConverter.toResponseDto(user))
                .responseGym(gymConverter.toResponseDto(subscription.getGym()))
                .typeSubscription(subscription.getTypeSubscription())
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
                    .responseUser(userConverter.toResponseDto(userRepository.findById(subscription.getUser().getId()).get()))
                    .typeSubscription(subscription.getTypeSubscription())
                    .description(subscription.getDescription())
                    .price(subscription.getPrice())
                    .hasCoach(subscription.isHasCoach())
                    .build());
        }
        return responseSubscription;
    }
}
