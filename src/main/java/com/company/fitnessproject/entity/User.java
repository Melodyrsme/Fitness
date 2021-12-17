package com.company.fitnessproject.entity;

import lombok.*;
import lombok.experimental.FieldDefaults;

import javax.persistence.*;

@Entity
@Table(name = "users")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Builder
@FieldDefaults(level = AccessLevel.PRIVATE)
public class User extends BaseEntity {
    @Column(name = "login", nullable = false, unique = true)
    String login;

    @Column(name = "password", nullable = false)
    String password;

    @Column(name = "is_active", nullable = false)
    Long isActive;
}