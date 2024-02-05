package com.realestate.repository;

import com.realestate.entity.Property;
import com.realestate.entity.PropertySearch;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface PropertySearchRepository extends JpaRepository<Property, Long> {

    @Query("SELECT p FROM Property p WHERE " +
            "(:location IS NULL OR p.location = :location) AND " +
            "(:propertyType IS NULL OR p.propertyType = :propertyType) AND " +
            "(:minPrice IS NULL OR p.price >= :minPrice) AND " +
            "(:maxPrice IS NULL OR p.price <= :maxPrice) AND " +
            "(:minBedrooms IS NULL OR p.bedroom >= :minBedrooms) AND " +
            "(:minBathrooms IS NULL OR p.bathroom >= :minBathrooms)")
    List<Property> searchProperties(@Param("location") String location,
                                    @Param("propertyType") String propertyType,
                                    @Param("minPrice") long minPrice,
                                    @Param("maxPrice") long maxPrice,
                                    @Param("minBedrooms") int minBedrooms,
                                    @Param("minBathrooms") int minBathrooms);


}
