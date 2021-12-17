package com.company.fitnessproject.repository;

import com.company.fitnessproject.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.time.LocalDateTime;

public interface UserRepository extends JpaRepository<User, Long> {
    User getUserByCreateTimeBetweenStartDate(LocalDateTime startDate, LocalDateTime endDate);
}
