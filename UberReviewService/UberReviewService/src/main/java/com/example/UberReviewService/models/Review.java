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


@Column(nullable = false)
private String content;

private Double rating;




@Override
        public String toString() {
            return "Review :" + this.content + " " + this.rating + " " + this.createdAt;
        }

}
