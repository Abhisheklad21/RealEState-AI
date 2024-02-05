package com.realestate.entity;



import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Property {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String location;
    private Double area;
    private String propertyType;
    private int bedroom;
    private int bathroom;
    private boolean parking;
    private boolean isFurished;
    private long price;

    // Add other fields as needed

    @OneToMany(mappedBy = "property", cascade = CascadeType.ALL)
    private List<Amenity> amenities;

    @OneToMany(mappedBy = "property", cascade = CascadeType.ALL)
    private List<Image> images;

    // Getters and setters
}
