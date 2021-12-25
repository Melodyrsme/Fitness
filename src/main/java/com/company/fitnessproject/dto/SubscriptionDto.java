package com.company.fitnessproject.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class SubscriptionDto {
    private Long gymId;

    private Long typeSubscriptionId;

    private Long userId;

    private BigDecimal price;

    private BigDecimal priceCoach;
}
