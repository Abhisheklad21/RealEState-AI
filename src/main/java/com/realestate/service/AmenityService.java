package com.realestate.service;

import com.realestate.entity.Amenity;

import java.util.List;

public interface AmenityService {
    List<Amenity> getAmenitiesByPropertyId(Long propertyId);
    Amenity saveAmenity(Amenity amenity);
    void deleteAmenity(Long id);
    // Additional methods if needed
}
