package com.company.fitnessproject.entity;

import lombok.*;
import lombok.experimental.FieldDefaults;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "gym")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Builder
@FieldDefaults(level = AccessLevel.PRIVATE)
public class Gym extends BaseEntity{
    @Column(name = "description")
    String description;

    @Column(name = "address")
    String address;
}
