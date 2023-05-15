package com.example.nickproject.repositories;

import com.example.nickproject.domains.Review;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ReviewRepository extends JpaRepository<Review, Long> {
}
