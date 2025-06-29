package com.example.UberReviewService.services;

import com.example.UberReviewService.models.Review;
import com.example.UberReviewService.repositoiries.ReviewRepository;
import jakarta.transaction.Transactional;
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

    @Override
    @Transactional
    public Review publishReview(Review request) {
        return reviewRepository.save(request);
    }

    @Override
    public Review updateReview(Long id, Review review) {
        Optional<Review> review1 = reviewRepository.findById(id);

        review1.ifPresent(review2 -> {
            //as any of the fields might not get updated, so will just keep the previous text
            review2.setRating(review.getRating() != null ? review.getRating() : review1.get().getRating());
            review2.setContent(review.getContent() != null ? review.getContent() : review1.get().getContent());
        });
        return reviewRepository.save(review1.get());
    }

}
