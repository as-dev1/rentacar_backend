package com.rent.rentacar.exception;

public class CarNotFoundException extends NotFoundException{
    public CarNotFoundException(Integer id){
        super("Car with id " + id + " not found");
    }
}
