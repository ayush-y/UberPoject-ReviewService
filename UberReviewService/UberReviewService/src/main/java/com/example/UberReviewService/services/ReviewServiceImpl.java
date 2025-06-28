package com.example.UberReviewService.services;

import com.example.UberReviewService.models.Review;
import com.example.UberReviewService.repositoiries.ReviewRepository;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Repository
@Service
public class ReviewServiceImpl implements ReviewService {

    public ReviewRepository reviewRepository;
    public ReviewServiceImpl(ReviewRepository reviewRepository) {
        this.reviewRepository = reviewRepository;
    }
    @Override
    public Optional<Review> findReviewById(Long id) {
        return reviewRepository.findById(id);
    }

    @Override
    public List<Review> listOfAllReviews() {
        return reviewRepository.findAll();
    }

    @Override
    public Boolean deleteReviewById(Long id) {
        try{
            reviewRepository.deleteById(id);
            return true;
        } catch (Exception e){
            return e.getMessage().equals("Review Not Found");
        }
    }
}
