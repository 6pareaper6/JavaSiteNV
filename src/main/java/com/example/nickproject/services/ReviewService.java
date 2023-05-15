package com.example.nickproject.services;

import com.example.nickproject.domains.Review;

import java.util.Optional;

public interface ReviewService {

    Optional<Review> findBysteamId(long id);

    void create(Review review);

    void update(Review review);

    void delete(Review review);
}
