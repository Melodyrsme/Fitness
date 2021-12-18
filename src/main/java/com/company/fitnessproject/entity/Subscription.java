package com.company.fitnessproject.entity;

import com.company.fitnessproject.enums.TypeMode;
import com.company.fitnessproject.enums.TypeSubscription;
import lombok.*;

import javax.persistence.*;
import java.math.BigDecimal;

@Entity
@Table(name = "subscriptionGym")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Builder
public class Subscription extends BaseEntity{
    @ManyToOne
    @JoinColumn(name = "gym_id", nullable = false)
    private Gym gym;

    @Enumerated(EnumType.STRING)
    @Column(name = "type_subscription", nullable = false)
    private TypeSubscription typeSubscription;

    @Enumerated(EnumType.STRING)
    @Column(name = "type_mode", nullable = false)
    private TypeMode typeMode;

    @Column(name = "description", nullable = false)
    private String description;

    @Column(name = "price", nullable = false)
    private BigDecimal price;

    @Column(name = "has_coach")
    private boolean hasCoach;
}
