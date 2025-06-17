package com.example.UberReviewService.services;

import com.example.UberReviewService.models.Review;
import com.example.UberReviewService.repositoiries.ReviewRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class ReviewService implements CommandLineRunner {

    private ReviewRepository reviewRepository; // Assuming you have a ReviewRepository defined
    public ReviewService(ReviewRepository reviewRepository) {
        this.reviewRepository = reviewRepository;
    }
    @Override
    public void run(String... args) throws Exception {

        System.out.println("ReviewService is running...");
        Review r = Review //code to create plain java object
                .builder()
                .content("Great service!")
                .rating(5.0)
                .build();
        System.out.println("Review object created: " + r);
        reviewRepository.save(r); // this code execute sql query to save the review object in the database
        List<Review > reviews = reviewRepository.findAll(); // this code execute sql query to fetch all the reviews from the database
        for(Review review : reviews) {
            System.out.println(r.getContent());
        }
    }

}
