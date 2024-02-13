package com.realestate.repository;

import com.realestate.entity.SubscriptionPlan;
import com.realestate.entity.UserSubscription;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;

@Repository
public interface UserSubscriptionRepository extends JpaRepository<UserSubscription, Long> {
    List<UserSubscription> findByEndDateAfter(LocalDate date);
}
