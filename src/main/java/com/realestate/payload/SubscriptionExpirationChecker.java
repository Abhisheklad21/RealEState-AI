package com.realestate.payload;

import com.realestate.entity.SubscriptionPlan;
import com.realestate.entity.UserSubscription;
import com.realestate.repository.UserSubscriptionRepository;
import com.realestate.service.SubscriptionPlanService;
import com.realestate.service.impl.UserSubscriptionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.util.List;

@Component
public class SubscriptionExpirationChecker {

    @Autowired
    private SubscriptionPlanService subscriptionPlanService;
    @Autowired
    private UserSubscriptionRepository userSubscriptionRepository;
    @Autowired
    private UserSubscriptionService userSubscriptionService;

    @Scheduled(cron = "0 0 0 * * *") // Run at midnight every day
    public void checkExpiredSubscriptionPlans() {
        // Get the current date
        LocalDate currentDate = LocalDate.now();

        // Query the database for expired subscription plans
        List<SubscriptionPlan> expiredPlans = userSubscriptionService.getExpiredPlans(currentDate);

        // Take further action on expired plans (e.g., update status, notify users)
        for (SubscriptionPlan plan : expiredPlans) {
            UserSubscription us = new UserSubscription();
            us.setExpired(true);
            subscriptionPlanService.savePlan(plan);
        }
    }
}
