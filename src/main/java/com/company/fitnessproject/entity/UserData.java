package com.company.fitnessproject.entity;

import lombok.*;

import javax.persistence.*;

@Entity
@Table(name = "user_data")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Builder
public class UserData extends BaseEntity {
    @OneToOne
    @JoinColumn(name = "subscription_id")
    private Subscription subscription;

    @OneToOne
    @JoinColumn(name = "user_id", nullable = false)
    private User user;

    @Column(name = "full_name", nullable = false)
    private String fullName;

    @Column(name = "age")
    private Long age;

    @Column(name = "phone_number", unique = true)
    private String phoneNumber;

    @Column(name = "address")
    private String address;

    @Column(name = "count")
    private Long count;
}
