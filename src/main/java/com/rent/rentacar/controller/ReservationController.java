package com.rent.rentacar.controller;

import com.rent.rentacar.entity.Reservation;
import com.rent.rentacar.service.ReservationService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "/api/reservation")
@CrossOrigin("http://localhost:5173")
@RequiredArgsConstructor
public class ReservationController {

    public final ReservationService service;

    @GetMapping
    public List<Reservation> getAllReservations() {
        return service.getAllReservations();
    }

    @GetMapping(path = "/{id}")
    public Reservation getReservationById(@PathVariable Integer id) {
        return service.getReservationById(id);
    }

    @PostMapping
    public Reservation createReservation(@RequestBody Reservation reservation) {
        return service.createReservation(reservation);
    }

    @DeleteMapping(path = "/{id}")
    public String deleteReservation(@PathVariable Integer id) {
        return service.deleteReservation(id);
    }
}
