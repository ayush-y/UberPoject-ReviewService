package com.example.UberReviewService.models;

import com.fasterxml.jackson.annotation.JsonInclude;
import jakarta.persistence.*;
import lombok.*;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import java.util.Date;
@Getter
@Setter

@NoArgsConstructor
@AllArgsConstructor
@Table(name = "bookingreview")
// This annotation specifies the name of the table in the database that this entity will map to
@Data
@Builder

@Entity
public class Review extends BaseModel{


@Column(nullable = false)
private String content;

private Double rating;




@Override
        public String toString() {
            return "Review :" + this.content + " " + this.rating + " " + this.createdAt;
        }

}
