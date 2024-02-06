package com.realestate.controller;

import com.realestate.entity.SubscriptionPlan;
import com.realestate.entity.UserSubscription;
import com.realestate.service.SubscriptionPlanService;
import com.realestate.service.impl.UserSubscriptionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/plans")
public class PlanController {

    @Autowired
    private SubscriptionPlanService subscriptionPlanService;

    @Autowired
    private UserSubscriptionService userSubscriptionService;

    // Endpoint to create a new subscription plan
    @PostMapping("/create")
    public SubscriptionPlan createPlan(@RequestBody SubscriptionPlan plan) {
        return subscriptionPlanService.savePlan(plan);
    }

    // Endpoint to get all subscription plans
    @GetMapping("/all")
    public List<SubscriptionPlan> getAllPlans() {
        return subscriptionPlanService.getAllPlans();
    }

    // Endpoint to get a subscription plan by ID
    @GetMapping("/{id}")
    public SubscriptionPlan getPlanById(@PathVariable Long id) {
        return subscriptionPlanService.getPlanById(id);
    }

    // Endpoint to update a subscription plan
    @PutMapping("/{id}")
    public SubscriptionPlan updatePlan(@PathVariable Long id, @RequestBody SubscriptionPlan updatedPlan) {
        return subscriptionPlanService.updatePlan(id, updatedPlan);
    }

    // Endpoint to delete a subscription plan
    @DeleteMapping("/{id}")
    public void deletePlan(@PathVariable Long id) {
        subscriptionPlanService.deletePlan(id);
    }

    //http://localhost:8080/api/plans/subscribe/{userid}
    @PostMapping("/subscribe/{id}")
    public ResponseEntity<?> subscribePlan(@PathVariable Long id, @RequestBody SubscriptionPlan subscriptionPlan) {
        UserSubscription userSubscription = userSubscriptionService.subscribePlan(id, subscriptionPlan);
        return new ResponseEntity<>("You have subscribed plan successfully and details are " + userSubscription, HttpStatus.OK);
    }
}
