package com.example.UberReviewService.models;
import jakarta.persistence.*;
import lombok.*;

@Getter
@Setter

@NoArgsConstructor
@AllArgsConstructor
@Table(name = "booking_review")
// This annotation specifies the name of the table in the database that this entity will map to
@Builder
@Entity
@Inheritance(strategy = InheritanceType.JOINED)
public class Review extends BaseModel{


    @OneToOne(cascade = {CascadeType.ALL}, fetch = FetchType.LAZY)
    @JoinColumn(nullable = false) //we can't use @Column directly on 1-to-1 mapping
    private Booking booking; //we define 1-to-1 relationship between Booking and Review

    @Column(nullable = false)
    private String content;

    private Double rating;


        @Override
    public String toString() {
            return "Review :" + this.getId() + " " + this.getBooking() + " " + this.getContent() + " " + this.getRating();
        }

}
