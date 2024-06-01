package com.rent.rentacar.service;

import com.rent.rentacar.exception.custom.ReservationNotFoundException;
import com.rent.rentacar.entity.Reservation;
import com.rent.rentacar.repository.ReservationRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
@RequiredArgsConstructor
public class ReservationService {

    private final ReservationRepository repository;

    public List<Reservation> getAllReservations() {
        return repository.findAllByDeletedAtIsNull();
    }

    public Reservation getReservationById(Integer id) {
        return repository.findByIdAndDeletedAtIsNull(id).orElseThrow(() -> new ReservationNotFoundException(id));
    }

    public Reservation createReservation(Reservation reservation) {
        reservation.setId(null);
        return repository.save(reservation);
    }

    public void deleteReservation(Integer id) {
        Reservation reservation = repository.findByIdAndDeletedAtIsNull(id).orElseThrow(() -> new ReservationNotFoundException(id));
        reservation.setDeletedAt(LocalDateTime.now());
        repository.save(reservation);
    }
}
