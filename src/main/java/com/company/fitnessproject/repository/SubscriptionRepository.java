package com.company.fitnessproject.repository;

import com.company.fitnessproject.entity.Subscription;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface SubscriptionRepository extends JpaRepository<Subscription, Long> {
    @Query(nativeQuery = true, value = "SELECT t.* FROM subscription_gym t WHERE t.user_id = :id")
    Subscription getSubscriptionByUser(Long id);

}
