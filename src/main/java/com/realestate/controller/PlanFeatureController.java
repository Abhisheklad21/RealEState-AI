package com.realestate.controller;

import com.realestate.entity.PlanFeature;
import com.realestate.service.PlanFeatureService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/plan-features")
public class PlanFeatureController {

    @Autowired
    private PlanFeatureService planFeatureService;

    @GetMapping("/all")
    public List<PlanFeature> getAllPlanFeatures() {
        return planFeatureService.getAllPlanFeatures();
    }

}
