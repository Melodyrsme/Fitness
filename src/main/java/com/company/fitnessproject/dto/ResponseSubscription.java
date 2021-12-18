package com.company.fitnessproject.dto;

import com.company.fitnessproject.enums.TypeMode;
import com.company.fitnessproject.enums.TypeSubscription;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import java.math.BigDecimal;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class ResponseSubscription {
    ResponseGym responseGym;

    @Enumerated(EnumType.STRING)
    private TypeSubscription typeSubscription;

    @Enumerated(EnumType.STRING)
    private TypeMode typeMode;

    private String description;

    private BigDecimal price;

    private boolean hasCoach;
}
