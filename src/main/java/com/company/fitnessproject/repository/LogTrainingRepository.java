package com.company.fitnessproject.repository;

import com.company.fitnessproject.entity.LogTraining;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LogTrainingRepository extends JpaRepository<LogTraining, Long> {
}
