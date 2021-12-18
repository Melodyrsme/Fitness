package com.company.fitnessproject.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class ResponseUserData {
    private ResponseSubscription responseSubscription;

    private ResponseUser responseUser;

    private String fullName;

    private Long age;

    private String phoneNumber;

    private String address;

    private Long count;
}
