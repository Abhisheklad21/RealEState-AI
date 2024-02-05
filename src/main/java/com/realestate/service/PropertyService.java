package com.realestate.service;

import com.realestate.entity.Property;

import java.util.List;

public interface PropertyService {
    List<Property> getAllProperties();
    Property getPropertyById(Long id);
    Property saveProperty(Property property);
    void deleteProperty(Long id);
    // Additional methods if needed
}
