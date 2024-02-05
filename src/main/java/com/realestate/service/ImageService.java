package com.realestate.service;

import com.realestate.entity.Image;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

public interface ImageService {
    List<Image> getImagesByPropertyId(Long propertyId);
    Image saveImage(Long propertyId, MultipartFile file);
    void deleteImage(Long id);
    // Additional methods if needed
}
