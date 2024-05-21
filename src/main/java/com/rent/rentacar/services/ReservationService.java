package com.rent.rentacar.services;

import com.rent.rentacar.models.Reservation;
import com.rent.rentacar.repositories.ReservationRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ReservationService {

    private final ReservationRepository repository;

    public List<Reservation> getAllReservations() {
        return repository.findAll();
    }

    public Reservation getReservationById(Integer id) {
        return repository.findById(id).orElse(null);
    }

    public Reservation createReservation(Reservation reservation) {
        return repository.save(reservation);
    }

    public void deleteReservation(Integer id) {
        repository.deleteById(id);
    }
}
