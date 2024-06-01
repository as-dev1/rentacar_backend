package com.rent.rentacar.service;

import com.rent.rentacar.entity.Review;
import com.rent.rentacar.exception.custom.ReviewNotFoundException;
import com.rent.rentacar.repository.ReviewRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
@RequiredArgsConstructor
public class ReviewService {
    
    private final ReviewRepository repository;

    public List<Review> getAllReviews() {
        return repository.findAllByDeletedAtIsNull();
    }

    public Review getReviewById(Integer id) {
        return repository.findByIdAndDeletedAtIsNull(id).orElseThrow(() -> new ReviewNotFoundException(id));
    }

    public Review createReview(Review review) {
        review.setId(null);
        return repository.save(review);
    }

    public void deleteReview(Integer id) {
        Review review = repository.findByIdAndDeletedAtIsNull(id).orElseThrow(() -> new ReviewNotFoundException(id));
        review.setDeletedAt(LocalDateTime.now());
        repository.save(review);
    }
}
