package com.rent.rentacar.repository;

import com.rent.rentacar.entity.Review;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface ReviewRepository extends JpaRepository<Review, Integer> {
    List<Review> findAllByDeletedAtIsNull();

    Optional<Review> findByIdAndDeletedAtIsNull(Integer id);
}
