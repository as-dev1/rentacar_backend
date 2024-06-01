package com.rent.rentacar.controller;

import com.rent.rentacar.entity.Review;
import com.rent.rentacar.service.ReviewService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "/api/review")
@CrossOrigin("http://localhost:5173")
@RequiredArgsConstructor
public class ReviewController {

    private final ReviewService service;

    @GetMapping
    public List<Review> getAllReviews() {
        return service.getAllReviews();
    }

    @GetMapping(path = "/{id}")
    public Review getReviewById(@PathVariable Integer id) {
        return service.getReviewById(id);
    }

    @GetMapping("/car/{carId}")
    public List<Review> getReviewsByCarId(@PathVariable Integer carId) {
        return service.getReviewsByCarId(carId);
    }

    @PostMapping
    public Review createReview(@RequestBody Review review) {
        return service.createReview(review);
    }

    @DeleteMapping(path = "/{id}")
    @ResponseStatus(code = HttpStatus.NO_CONTENT)
    public void deleteReview(@PathVariable Integer id) {
        service.deleteReview(id);
    }
}
