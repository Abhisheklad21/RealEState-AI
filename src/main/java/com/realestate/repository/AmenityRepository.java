package com.realestate.repository;

import com.realestate.entity.Amenity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AmenityRepository extends JpaRepository<Amenity, Long> {
    // Additional query methods if needed
}
