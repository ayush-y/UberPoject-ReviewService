package com.example.UberReviewService.services;

import com.example.UberReviewService.models.Booking;
import com.example.UberReviewService.models.Driver;
import com.example.UberReviewService.models.Review;
import com.example.UberReviewService.repositoiries.BookingRepository;
import com.example.UberReviewService.repositoiries.DriverRepository;
import com.example.UberReviewService.repositoiries.ReviewRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Service;

import java.sql.SQLOutput;
import java.util.Date;
import java.util.List;
import java.util.Optional;

@Service
public class ReviewService implements CommandLineRunner {

    private final BookingRepository bookingRepository;
    private final ReviewRepository reviewRepository; // Assuming you have a ReviewRepository defined
    private final DriverRepository driverRepository; // Assuming you have a DriverRepository defined
    public ReviewService(ReviewRepository reviewRepository,
                         BookingRepository bookingRepository,
                         DriverRepository driverRepository) {
        this.reviewRepository = reviewRepository;
        this.bookingRepository = bookingRepository; // Injecting BookingRepository to save Booking objects
        this.driverRepository = driverRepository; // Injecting DriverRepository to fetch Driver objects

    }
    @Override
    public void run(String... args) throws Exception {

        System.out.println("ReviewService is running...");

//        Review r = Review //code to create plain java object
//                .builder()
//                .content("Great service!")
//                .rating(5.0)
//                .build();
//
//        Booking b = Booking
//                .builder()
//                .review(r) // setting the review object in the booking object
//                .endTime(new Date())
//                .build();
//
//        bookingRepository.save(b); // this code execute sql query to save the booking object in the database
//
//        System.out.println("Review object created: " + r);
//
//        List<Review > reviews = reviewRepository.findAll(); // this code execute sql query to fetch all the reviews from the database
//        for(Review review : reviews) {
//            System.out.println(r.getContent());
//        }

//        Optional<Driver> driver = driverRepository.findById(1L);
//        if(driver.isPresent()){
//
//            System.out.println(driver.get().getName() + " is present with license number UP16C007");
//            List<Booking> b = driver.get().getBookings();
//            List<Booking> bookings = bookingRepository.findAllByDriverId(1L);
//            for(Booking  : bookings) {
//                System.out.println(booking.getBookingStatus());
//            }
//            for (Booking booking : b){
//                System.out.println(booking.getId());
//            }
//
//
//        }
        Optional<Driver> d = driverRepository.hqlFindByIdAndLicense(1L, "UP16C007");
        System.out.println(d.get().getName());

    }

}
