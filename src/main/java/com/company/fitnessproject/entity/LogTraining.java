package com.company.fitnessproject.entity;

import lombok.*;
import lombok.experimental.FieldDefaults;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "log_training")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Builder
@FieldDefaults(level = AccessLevel.PRIVATE)
public class LogTraining extends BaseEntity{
    @ManyToOne
    @JoinColumn(name = "user_id", nullable = false)
    User user;

    @Column(name = "training_time")
    LocalDateTime trainingTime;
}
