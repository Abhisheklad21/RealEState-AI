package com.realestate.controller;

import com.realestate.entity.Amenity;
import com.realestate.service.AmenityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/amenities")
public class AmenityController {

    @Autowired
    private AmenityService amenityService;

    @GetMapping("/by-property/{propertyId}")
    public List<Amenity> getAmenitiesByPropertyId(@PathVariable Long propertyId) {
        return amenityService.getAmenitiesByPropertyId(propertyId);
    }

    @PostMapping("/create")
    public Amenity saveAmenity(@RequestBody Amenity amenity) {
        return amenityService.saveAmenity(amenity);
    }

    @DeleteMapping("/delete/{id}")
    public void deleteAmenity(@PathVariable Long id) {
        amenityService.deleteAmenity(id);
    }
}
