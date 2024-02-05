package com.realestate.service;

import com.realestate.entity.Review;

import java.util.List;

public interface ReviewService {
    List<Review> getReviewsByPropertyId(Long propertyId);
    Review saveReview(Long propertyId, Long userId, Review review);
    void deleteReview(Long id);
    // Additional methods if needed
}
