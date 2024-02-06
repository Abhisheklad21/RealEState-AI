package com.realestate.payload;

import com.realestate.entity.UserSubscription;
import com.realestate.service.impl.UserSubscriptionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.util.*;

@Component
public class SubscriptionExpirationScheduler {

    @Autowired
    private UserSubscriptionService userSubscriptionService;

    @Scheduled(fixedRate = 86400000) // Run every day (86400000 milliseconds = 1 day)
    public void checkSubscriptionValidity() {
        List<UserSubscription> subscriptions = userSubscriptionService.getAllSubscriptions();
        LocalDate today = LocalDate.now();

        for (UserSubscription subscription : subscriptions) {
            if (subscription.getEndDate().isBefore(today)) {
                // Expire the subscription
                subscription.setExpired(true);
                userSubscriptionService.saveSubscription(subscription);
            }
        }
    }
}
