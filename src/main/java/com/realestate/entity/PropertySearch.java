package com.realestate.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class PropertySearch {
    private String location;
    private String propertyType;
    private long minPrice;
    private long maxPrice;
    private int minBedrooms;
    private int minBathrooms;
    // Add other search criteria as needed
}
