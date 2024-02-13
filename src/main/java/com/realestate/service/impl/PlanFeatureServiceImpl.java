package com.realestate.service.impl;


import com.realestate.entity.PlanFeature;
import com.realestate.repository.PlanFeatureRepository;
import com.realestate.service.PlanFeatureService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PlanFeatureServiceImpl implements PlanFeatureService {

    @Autowired
    private PlanFeatureRepository planFeatureRepository;

    @Override
    public List<PlanFeature> getAllPlanFeatures() {
        return planFeatureRepository.findAll();
    }
}