package com.company.fitnessproject.entity;

import com.company.fitnessproject.enums.TypeMode;
import com.company.fitnessproject.enums.TypeSubscription;
import lombok.*;
import lombok.experimental.FieldDefaults;

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
@FieldDefaults(level = AccessLevel.PRIVATE)
public class Subscription extends BaseEntity{

    @ManyToOne
    @JoinColumn(name = "gym_id", nullable = false)
    Gym gym;

    @Enumerated(EnumType.STRING)
    @Column(name = "type_subscription", nullable = false)
    TypeSubscription typeSubscription;

    @Enumerated(EnumType.STRING)
    @Column(name = "type_mode", nullable = false)
    TypeMode typeMode;

    @Column(name = "description", nullable = false)
    String description;

    @Column(name = "price", nullable = false)
    BigDecimal price;

    @Column(name = "has_coach")
    boolean hasCoach;
}
