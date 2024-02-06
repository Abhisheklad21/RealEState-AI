package com.realestate.service.impl;

import com.realestate.entity.SubscriptionPlan;
import com.realestate.entity.User;
import com.realestate.entity.UserSubscription;
import com.realestate.repository.SubscriptionPlanRepository;
import com.realestate.repository.UserRepository;
import com.realestate.repository.UserSubscriptionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@Service
public class UserSubscriptionService {

    @Autowired
    private UserSubscriptionRepository userSubscriptionRepository;
    @Autowired
    private SubscriptionPlanRepository subscriptionPlanRepository;
    @Autowired
    private UserRepository userRepository;

    public List<UserSubscription> getAllSubscriptions() {
        return userSubscriptionRepository.findAll();
    }

    public UserSubscription getSubscriptionById(Long id) {
        return userSubscriptionRepository.findById(id).orElse(null);
    }

    public UserSubscription saveSubscription(UserSubscription subscription) {
        return userSubscriptionRepository.save(subscription);
    }

    public void deleteSubscription(Long id) {
        userSubscriptionRepository.deleteById(id);
    }

    public UserSubscription subscribePlan(Long id, SubscriptionPlan subscriptionPlan) {
        Optional<SubscriptionPlan> planById = subscriptionPlanRepository.findById(id);
        Optional<User> userById = userRepository.findById(subscriptionPlan.getUserId());
        UserSubscription us=new UserSubscription();
        SubscriptionPlan plan = planById.orElseThrow(() -> new IllegalArgumentException("Plan not found"));
        User user = userById.orElseThrow(() -> new IllegalArgumentException("User not found"));
        us.setPlan(plan);
        int validityInDays = plan.getDurationInDays();
        us.setUser(user);
        us.setStartDate(LocalDate.now());
        LocalDate currentDate = LocalDate.now();
        LocalDate expirationDate = currentDate.plusDays(validityInDays);
        us.setEndDate(expirationDate);
       return userSubscriptionRepository.save(us);

    }

    public List<SubscriptionPlan> getExpiredPlans(LocalDate currentDate) {
        // Query the repository for expired subscription plans
        return subscriptionPlanRepository.findByExpirationDateBeforeAndExpiredFalse(currentDate);
    }

    // Other methods as needed
}
