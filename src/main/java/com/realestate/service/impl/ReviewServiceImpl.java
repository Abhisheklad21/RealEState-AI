package com.realestate.service.impl;

import com.realestate.entity.Property;
import com.realestate.entity.Review;
import com.realestate.entity.User;
import com.realestate.repository.PropertyRepository;
import com.realestate.repository.ReviewRepository;
import com.realestate.repository.UserRepository;
import com.realestate.service.ReviewService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.Date;
import java.util.List;

@Service
public class ReviewServiceImpl implements ReviewService {

    @Autowired
    private ReviewRepository reviewRepository;

    @Autowired
    private PropertyRepository propertyRepository;

    @Autowired
    private UserRepository userRepository;

    @Override
    public List<Review> getReviewsByPropertyId(Long propertyId) {
        // Implement logic to retrieve reviews by property ID
        return reviewRepository.findAllById(Collections.singleton(propertyId));
    }

    @Override
    public Review saveReview(Long propertyId, Long userId, Review review) {
        Property property = propertyRepository.findById(propertyId).orElse(null);
        User user = userRepository.findById(userId).orElse(null);

        if (property != null && user != null) {
            review.setProperty(property);
            review.setUser(user);
            review.setDate(new Date());
            return reviewRepository.save(review);
        }
        return null;
    }

    @Override
    public void deleteReview(Long id) {
        reviewRepository.deleteById(id);
    }
}
