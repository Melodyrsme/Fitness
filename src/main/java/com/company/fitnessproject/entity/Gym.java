package com.company.fitnessproject.entity;

import lombok.*;

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
public class Gym extends BaseEntity {
    @Column(name = "description")
    private String description;

    @Column(name = "address")
    private String address;
}
