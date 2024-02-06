package com.realestate.service;

import com.realestate.entity.SubscriptionPlan;

import java.time.LocalDate;
import java.util.List;

public interface SubscriptionPlanService {
    SubscriptionPlan savePlan(SubscriptionPlan plan);
    List<SubscriptionPlan> getAllPlans();
    SubscriptionPlan getPlanById(Long id);
    SubscriptionPlan updatePlan(Long id, SubscriptionPlan updatedPlan);
    void deletePlan(Long id);



}
