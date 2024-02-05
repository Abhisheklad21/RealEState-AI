package com.realestate.service;

import com.realestate.entity.Amenity;
import com.realestate.repository.AmenityRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AmenityServiceImpl implements AmenityService {

    @Autowired
    private AmenityRepository amenityRepository;

    @Override
    public List<Amenity> getAmenitiesByPropertyId(Long propertyId) {
        // Implement logic to retrieve amenities by property ID
        return amenityRepository.findAll();
    }

    @Override
    public Amenity saveAmenity(Amenity amenity) {
        return amenityRepository.save(amenity);
    }

    @Override
    public void deleteAmenity(Long id) {
        amenityRepository.deleteById(id);
    }
}
