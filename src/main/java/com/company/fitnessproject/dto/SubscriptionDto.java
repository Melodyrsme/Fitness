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
    Long gymId;

    Long typeSubscriptionId;

    Long typeModId;

    private String description;

    private BigDecimal price;

    private boolean hasCoach;
}
