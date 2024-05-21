package com.rent.rentacar.exception;

public class ReservationNotFoundException extends RuntimeException{
    public ReservationNotFoundException(Integer id){
        super("Reservation with id " + id + " not found");
    }
}
