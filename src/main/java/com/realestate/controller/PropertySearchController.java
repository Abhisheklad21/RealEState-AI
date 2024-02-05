package com.realestate.controller;

import com.realestate.entity.Property;
import com.realestate.entity.PropertySearch;
import com.realestate.service.PropertySearchService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/property-search")
public class PropertySearchController {

    @Autowired
    private PropertySearchService propertySearchService;

    @PostMapping("/search")
    public List<Property> searchProperties(@RequestBody PropertySearch propertySearch) {
        return propertySearchService.searchProperties(propertySearch);
    }
}
