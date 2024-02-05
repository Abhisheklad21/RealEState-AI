package com.realestate.service.impl;

import com.realestate.entity.Property;
import com.realestate.entity.PropertySearch;
import com.realestate.repository.PropertySearchRepository;
import com.realestate.service.PropertySearchService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PropertySearchServiceImpl implements PropertySearchService {

    @Autowired
    private PropertySearchRepository propertySearchRepository;

    @Override
    public List<Property> searchProperties(PropertySearch propertySearch) {
        return propertySearchRepository.searchProperties(
                propertySearch.getLocation(),
                propertySearch.getPropertyType(),
                propertySearch.getMinPrice(),
                propertySearch.getMaxPrice(),
                propertySearch.getMinBedrooms(),
                propertySearch.getMinBathrooms()
        );
    }
}
