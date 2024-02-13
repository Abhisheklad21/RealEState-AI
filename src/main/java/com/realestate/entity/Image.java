package com.realestate.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import javax.persistence.*;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Image {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    // Updated to store the image as a byte array
    @Lob
    private byte[] imageData;

    @ManyToOne
    @JoinColumn(name = "property_id")
    private Property property;

    // Getters and setters
}
