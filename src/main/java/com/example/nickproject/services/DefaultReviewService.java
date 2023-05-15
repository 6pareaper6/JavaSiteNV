package com.example.nickproject.services;

import com.example.nickproject.domains.Review;
import com.example.nickproject.repositories.ReviewRepository;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Service
@Transactional
public class DefaultReviewService implements ReviewService{

    private final ReviewRepository reviewRepository;

    public DefaultReviewService(ReviewRepository reviewRepository) {
        this.reviewRepository = reviewRepository;
    }

    @Override
    public Optional<Review> findBysteamId(long id) {
        return reviewRepository.findById(id);
    }

    @Override
    public void create(Review review) {
        reviewRepository.save(review);
    }

    @Override
    public void update(Review review) {
        reviewRepository.save(review);
    }

    @Override
    public void delete(Review review) {
        try {
            reviewRepository.delete(review);
        }
        catch(EmptyResultDataAccessException ex)
        {

        }
    }
}
