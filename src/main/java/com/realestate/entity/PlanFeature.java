package com.realestate.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import javax.persistence.*;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Data
@Table(name = "plan_features")
public class PlanFeature {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private boolean guaranteedBuyers;
    private boolean personalFieldAssistant;
    private boolean propertyPromotionOnSite;
    private boolean relationshipManager;
    private boolean facebookMarketing;
    private boolean privacyOfPhoneNumber;
    private boolean showingPropertyOnBehalf;
    private boolean propertyPhotoshoot;


    @ManyToOne
    private SubscriptionPlan subscriptionPlan;

}

