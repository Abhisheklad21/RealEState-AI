package com.realestate.service.impl;

import com.realestate.entity.Image;
import com.realestate.entity.Property;
import com.realestate.repository.ImageRepository;
import com.realestate.service.ImageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Collections;
import java.util.List;

@Service
public class ImageServiceImpl implements ImageService {

    Image image = new Image();
    @Autowired
    private ImageRepository imageRepository;

    @Override
    public List<Image> getImagesByPropertyId(Long propertyId) {

        List<Image> allById = imageRepository.findAllById(Collections.singleton(propertyId));

        return imageRepository.findAll();
    }

    @Override
    public Image saveImage(Long propertyId, MultipartFile file) {

        try {
            image.setImageData(file.getBytes());

        } catch (IOException e) {
            // Handle the exception (e.g., log it)
            e.printStackTrace();
            return null;
        }
        // Set the associated property
        Property property = new Property();
        property.setId(propertyId);
        image.setProperty(property);

        Image savedImage = imageRepository.save(image);

        // Specify the file path where you want to save the image file
        String filePath = "/path/to/save/" + savedImage.getId() + ".jpg";

        // Use the ImageService to save the image to a file
        saveImageToFile(savedImage.getImageData(), filePath);

        return savedImage;
    }

    @Override
    public void deleteImage(Long id) {
        imageRepository.deleteById(id);
    }

    private void saveImageToFile(byte[] imageData, String filePath) {
        try (FileOutputStream fos = new FileOutputStream(filePath)) {
            fos.write(imageData);
        } catch (IOException e) {
            // Handle the exception (e.g., log it)
            e.printStackTrace();
        }
    }
}
