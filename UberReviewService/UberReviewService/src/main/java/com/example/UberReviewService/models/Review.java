package com.example.UberReviewService.models;

import jakarta.persistence.*;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;

import java.util.Date;

@Entity
@Table(name = "bookingreview") // This annotation specifies the name of the table in the database that this entity will map to
public class Review {
@Id // This annotation indicates that the field is the primary key of the entity
        @GeneratedValue(strategy = GenerationType.IDENTITY) // This annotation is used to specify that the value of the primary key will be generated automatically
Long id;

@Column(nullable = false)
String content;

double rating;


@Column(nullable = false)
@Temporal(TemporalType.TIMESTAMP) // This annotation specifies that the date should be stored as a timestamp
@CreatedDate //This annotation indicates that this field will be automatically populated with the current date and time when the entity is created
Date createdAt;

@Temporal(TemporalType.TIMESTAMP)
@LastModifiedDate // This annotation indicates that this field will be automatically populated with the current date and time when the entity is updated
@Column(nullable = false)
Date updatedAt;


}
