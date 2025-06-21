package com.example.UberReviewService.models;

import jakarta.persistence.Entity;
import jakarta.persistence.OneToMany;
import lombok.*;

import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Passenger extends BaseModel{

    private String name;

    @OneToMany(mappedBy = "passenger")
    private List<Booking> bookings = new ArrayList<>(); // 1 : n mapping -> passenger : Booking

}
