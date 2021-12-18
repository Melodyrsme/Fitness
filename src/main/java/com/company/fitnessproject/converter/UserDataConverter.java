package com.company.fitnessproject.converter;

import com.company.fitnessproject.dto.ResponseUserData;
import com.company.fitnessproject.dto.UserDataDto;
import com.company.fitnessproject.entity.UserData;
import com.company.fitnessproject.repository.SubscriptionRepository;
import com.company.fitnessproject.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
@RequiredArgsConstructor
public class UserDataConverter {
    private final SubscriptionRepository subscriptionRepository;
    private final SubscriptionConverter subscriptionConverter;
    private final UserRepository userRepository;
    private final UserConverter userConverter;

    public UserData toEntity(UserDataDto userDataDto) {
        return UserData.builder()
                .subscription(subscriptionRepository.findById(userDataDto.getSubscriptionId()).get())
                .user(userRepository.findByLogin(SecurityContextHolder.getContext().getAuthentication().getName()))
                .fullName(userDataDto.getFullName())
                .address(userDataDto.getAddress())
                .age(userDataDto.getAge())
                .phoneNumber(userDataDto.getPhoneNumber())
                .count(userDataDto.getCount())
                .build();
    }

    public ResponseUserData toResponseDto(UserData userData) {
        return ResponseUserData.builder()
                .responseSubscription(subscriptionConverter.toResponseDto(userData.getSubscription()))
                .responseUser(userConverter.toResponseDto(userData.getUser()))
                .fullName(userData.getFullName())
                .address(userData.getAddress())
                .age(userData.getAge())
                .phoneNumber(userData.getPhoneNumber())
                .count(userData.getCount())
                .build();
    }

    public List<ResponseUserData> toResponsesDto(List<UserData> users) {
        List<ResponseUserData> responseUsers = new ArrayList<>();
        for (UserData userData : users) {
            responseUsers.add(ResponseUserData.builder()
                    .responseSubscription(subscriptionConverter.toResponseDto(userData.getSubscription()))
                    .responseUser(userConverter.toResponseDto(userData.getUser()))
                    .fullName(userData.getFullName())
                    .address(userData.getAddress())
                    .age(userData.getAge())
                    .phoneNumber(userData.getPhoneNumber())
                    .count(userData.getCount())
                    .build());
        }
        return responseUsers;
    }
}
