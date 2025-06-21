package com.example.UberReviewService.models;

import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.Cascade;

import java.util.Date;

@Getter
@Setter
@Builder
@AllArgsConstructor
@Entity
public class Booking extends BaseModel {

    @OneToOne(cascade = {CascadeType.PERSIST, CascadeType.REMOVE })
    private Review review; //we define 1-to-1 relationship between Booking and Review

    @Enumerated(value = EnumType.STRING)
    private BookingStatus bookingStatus;

    @Temporal(value = TemporalType.TIMESTAMP)
    private Date startTime;

    @Temporal(value = TemporalType.TIMESTAMP)
    private Date endTime;

    @Temporal(value = TemporalType.TIMESTAMP)
    private Long totalDistance;
}
