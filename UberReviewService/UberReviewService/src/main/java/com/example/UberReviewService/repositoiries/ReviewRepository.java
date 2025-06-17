package com.example.UberReviewService.repositoiries;
import com.example.UberReviewService.models.Review;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ReviewRepository extends JpaRepository<Review, Long> {


    // This interface extends JpaRepository, which provides methods for CRUD operations
    // on the Review entity. The first parameter is the entity type, and the second is the type of the primary key.

}
