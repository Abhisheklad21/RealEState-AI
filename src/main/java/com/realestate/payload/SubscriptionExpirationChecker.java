package com.realestate.payload;

import com.realestate.entity.SubscriptionPlan;
import com.realestate.entity.User;
import com.realestate.entity.UserSubscription;
import com.realestate.repository.UserRepository;
import com.realestate.repository.UserSubscriptionRepository;
import com.realestate.service.SubscriptionPlanService;
import com.realestate.service.impl.UserSubscriptionService;
import com.realestate.util.EmailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@Component
public class SubscriptionExpirationChecker {

    @Autowired
    private SubscriptionPlanService subscriptionPlanService;
    @Autowired
    private UserSubscriptionRepository userSubscriptionRepository;
    @Autowired
    private UserSubscriptionService userSubscriptionService;
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private EmailService emailService;

    @Scheduled(cron = "0 35 14 * * *") // Run at 2:30 PM every day
    public void checkExpiredSubscriptionPlans() {
        // Get the current date
        LocalDate currentDate = LocalDate.now();

        // Query the database for expired subscription plans
        List<UserSubscription> expiredPlans = userSubscriptionService.getExpiredPlans(currentDate);

        // Take further action on expired plans (e.g., update status, notify users)
        for (UserSubscription plan : expiredPlans) {
            plan.setExpired(true);
            System.out.println(plan.getUser());
            User user = plan.getUser();
            Optional<User> userbyID = userRepository.findById(user.getId());
            System.out.println(userbyID);
            emailService.sendPlanExpiryEmail(userbyID.get().getEmail());
            userSubscriptionService.savePlan(plan);

        }
    }
}
