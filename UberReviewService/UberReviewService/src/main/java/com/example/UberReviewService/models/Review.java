package com.example.UberReviewService.models;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity
public class Review {
@Id // This annotation indicates that the field is the primary key of the entity
Long id;
}
