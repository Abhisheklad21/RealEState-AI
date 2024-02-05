package com.realestate.controller;

import com.realestate.entity.Review;
import com.realestate.service.ReviewService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/reviews")
public class ReviewController {

    @Autowired
    private ReviewService reviewService;

    @GetMapping("/by-property/{propertyId}")
    public List<Review> getReviewsByPropertyId(@PathVariable Long propertyId) {
        return reviewService.getReviewsByPropertyId(propertyId);
    }

    @PostMapping("/create/{propertyId}/{userId}")
    public Review saveReview(@PathVariable Long propertyId, @PathVariable Long userId, @RequestBody Review review) {
        return reviewService.saveReview(propertyId, userId, review);
    }

    @DeleteMapping("/delete/{id}")
    public void deleteReview(@PathVariable Long id) {
        reviewService.deleteReview(id);
    }
}
