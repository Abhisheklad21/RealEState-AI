package com.realestate.controller;

import com.realestate.entity.Image;
import com.realestate.service.ImageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

@RestController
@RequestMapping("/api/images")
public class ImageController {

    @Autowired
    private ImageService imageService;
    //http://localhost:8080/api/images/by-property/2
    @GetMapping("/by-property/{propertyId}")
    public List<Image> getImagesByPropertyId(@PathVariable Long propertyId) {
        return imageService.getImagesByPropertyId(propertyId);
    }

    @PostMapping("/upload/{propertyId}")
    public Image uploadImage(@PathVariable Long propertyId, @RequestParam("file") MultipartFile file) {
        return imageService.saveImage(propertyId, file);
    }

    @DeleteMapping("/delete/{id}")
    public void deleteImage(@PathVariable Long id) {
        imageService.deleteImage(id);
    }
}
