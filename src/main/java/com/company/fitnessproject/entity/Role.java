package com.company.fitnessproject.entity;

import lombok.*;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "roles")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Builder
public class Role extends BaseEntity {
    @Column(name = "name_role", nullable = false, unique = true)
    private String nameRole;
}
