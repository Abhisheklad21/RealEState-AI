package com.realestate.service;

import com.realestate.entity.Property;
import com.realestate.entity.PropertySearch;

import java.util.List;

public interface PropertySearchService {
    List<Property> searchProperties(PropertySearch propertySearch);
}
