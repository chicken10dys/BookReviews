package com.enterprise.java.repositories;

import com.enterprise.java.models.Review;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import java.util.List;

// Repository for reviews. Declares custom query to get reviews by bookId
@RepositoryRestResource(path = "reviews")
public interface ReviewRepository extends JpaRepository<Review, Integer> {
    List<Review> findByBookId(@Param("id") int bookId);
}
