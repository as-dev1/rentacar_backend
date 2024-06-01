package com.rent.rentacar.repository;

import com.rent.rentacar.entity.Reservation;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface ReservationRepository extends JpaRepository<Reservation, Integer> {
    List<Reservation> findAllByDeletedAtIsNull();

    Optional<Reservation> findByIdAndDeletedAtIsNull(Integer id);

    List<Reservation> findByCarIdAndDeletedAtIsNull(Integer carId);
}
