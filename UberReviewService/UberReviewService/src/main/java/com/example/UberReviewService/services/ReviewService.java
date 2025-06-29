package com.example.UberReviewService.services;

import com.example.UberReviewService.models.Review;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface ReviewService {

    public Optional<Review> findReviewById(Long id);

    public List<Review> listOfAllReviews();

    public Boolean deleteReviewById(Long id);

    public Review publishReview(Review request);

    public Review updateReview(Long id, Review review);

}
