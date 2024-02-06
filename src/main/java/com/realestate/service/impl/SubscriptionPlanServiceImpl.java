package com.realestate.service.impl;

import com.realestate.entity.SubscriptionPlan;
import com.realestate.repository.SubscriptionPlanRepository;
import com.realestate.service.SubscriptionPlanService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
public class SubscriptionPlanServiceImpl implements SubscriptionPlanService {

    @Autowired
    private SubscriptionPlanRepository subscriptionPlanRepository;

    @Override
    public SubscriptionPlan savePlan(SubscriptionPlan plan) {
        return subscriptionPlanRepository.save(plan);
    }

    @Override
    public List<SubscriptionPlan> getAllPlans() {
        return subscriptionPlanRepository.findAll();
    }

    @Override
    public SubscriptionPlan getPlanById(Long id) {
        return subscriptionPlanRepository.findById(id).orElse(null);
    }

    @Override
    public SubscriptionPlan updatePlan(Long id, SubscriptionPlan updatedPlan) {
        if (!subscriptionPlanRepository.existsById(id)) {
            // Handle not found case
            return null;
        }
        updatedPlan.setId(id);
        return subscriptionPlanRepository.save(updatedPlan);
    }

    @Override
    public void deletePlan(Long id) {
        subscriptionPlanRepository.deleteById(id);
    }




}
