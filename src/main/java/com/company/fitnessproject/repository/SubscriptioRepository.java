package com.company.fitnessproject.repository;

import com.company.fitnessproject.entity.Subscription;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SubscriptioRepository extends JpaRepository<Subscription, Long> {
}
