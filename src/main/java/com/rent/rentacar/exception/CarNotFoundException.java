package com.rent.rentacar.exception;

public class CarNotFoundException extends RuntimeException{
    public CarNotFoundException(Integer id){
        super("Car with id " + id + " not found");
    }
}
