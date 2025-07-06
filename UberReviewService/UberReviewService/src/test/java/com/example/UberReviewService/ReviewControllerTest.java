package com.example.UberReviewService;

import com.example.UberReviewService.Controllers.ReviewController;
import com.example.UberReviewService.adapters.CreateReviewDtoToReviewAdapter;
import com.example.UberReviewService.dtos.CreateReviewDto;
import com.example.UberReviewService.models.Booking;
import com.example.UberReviewService.models.Review;
import com.example.UberReviewService.services.ReviewService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.*;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.*;

public class ReviewControllerTest {

    @InjectMocks
    private ReviewController reviewController;

    @Mock
    private ReviewService  reviewService;

    @Mock
    private CreateReviewDtoToReviewAdapter createReviewDtoToReviewAdapter;

    @BeforeEach
    public void setUp(){
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void testFindReviewById_Success(){
        long reviewId = 1L;
        Review mockReview = Review.builder().build();
        mockReview.setId(reviewId);

        //mocking
        when(reviewService.findReviewById(reviewId))
                .thenReturn(Optional.of(mockReview));

        //perform the test
        ResponseEntity<?> response = reviewController.findReviewById(reviewId);

        //assertion
        assertEquals(HttpStatus.OK, response.getStatusCode());
        Optional<Review> returnedReview = (Optional<Review>) response.getBody();
        assertEquals(reviewId, returnedReview.get().getId());

    }
    @Test
    public void testDeleteReviewById_Success(){
        Long reviewId = 1L;
        Review  mockReview = Review.builder().build();
        mockReview.setId(reviewId);

        // Mock the void method (no return)
       when(reviewService.deleteReviewById(reviewId)).thenReturn(Boolean.TRUE);

       //perform the test
        ResponseEntity<?> response = reviewController.deleteReviewById(reviewId);

        //assertion
        assertEquals(HttpStatus.OK, response.getStatusCode());
    }
    @Test
    public void testPublishReview_Success(){

        CreateReviewDto requestDto = new CreateReviewDto();
        Booking booking = new Booking();
        booking.setId(1L);
        requestDto.setBookingId(booking.getId());

        Review incomingReview = Review.builder()
                .content("Test content")
                .rating(4.6)
                .booking(booking)
                .build();
        when(createReviewDtoToReviewAdapter.convertDto(requestDto)).thenReturn(incomingReview);

        Review savedReview =  Review.builder()
                .content(incomingReview.getContent())
                .rating(incomingReview.getRating())
                .booking(incomingReview.getBooking())
                .build();
        when(reviewService.publishReview(incomingReview)).thenReturn(savedReview);
        //assertion
        ResponseEntity<?> response = reviewController.publishReview(requestDto);

        assertEquals(HttpStatus.CREATED, response.getStatusCode());

 //       Review returnedReview = (Review) response.getBody();
 //       assertEquals(booking.getId(), returnedReview.getBooking().getId());
    }


}
