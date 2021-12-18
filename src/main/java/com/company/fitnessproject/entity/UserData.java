package com.company.fitnessproject.entity;


import lombok.*;
import lombok.experimental.FieldDefaults;

import javax.persistence.*;

@Entity
@Table(name = "user_data")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Builder
@FieldDefaults(level = AccessLevel.PRIVATE)
public class UserData extends BaseEntity {
    @OneToOne
    @JoinColumn(name = "subscription_id")
    Subscription subscription;

    @OneToOne
    @JoinColumn(name = "user_id", nullable = false)
    User user;

    @Column(name = "full_name", nullable = false)
    String fullName;

    @Column(name = "age")
    Long age;

    @Column(name = "phone_number", unique = true)
    String phoneNumber;

    @Column(name = "address")
    String address;

    @Column(name = "count")
    Long count;
}
