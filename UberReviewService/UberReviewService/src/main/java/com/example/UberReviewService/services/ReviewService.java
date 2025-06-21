package com.example.UberReviewService.services;

import com.example.UberReviewService.models.Booking;
import com.example.UberReviewService.models.Review;
import com.example.UberReviewService.repositoiries.ReviewRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class ReviewService implements CommandLineRunner {

    private final BookingRepository bookingRepository;
    private final ReviewRepository reviewRepository; // Assuming you have a ReviewRepository defined
    public ReviewService(ReviewRepository reviewRepository, BookingRepository bookingRepository) {
        this.reviewRepository = reviewRepository;
        this.bookingRepository = bookingRepository; // Injecting BookingRepository to save Booking objects

    }
    @Override
    public void run(String... args) throws Exception {

        System.out.println("ReviewService is running...");

        Review r = Review //code to create plain java object
                .builder()
                .content("Great service!")
                .rating(5.0)
                .build();

        Booking b = Booking
                .builder()
                .review(r) // setting the review object in the booking object
                .endTime(new Date())
                .build();

        bookingRepository.save(b); // this code execute sql query to save the booking object in the database

        System.out.println("Review object created: " + r);

        List<Review > reviews = reviewRepository.findAll(); // this code execute sql query to fetch all the reviews from the database
        for(Review review : reviews) {
            System.out.println(r.getContent());
        }
    }

}
