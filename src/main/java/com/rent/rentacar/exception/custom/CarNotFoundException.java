package com.rent.rentacar.exception.custom;

public class CarNotFoundException extends NotFoundException{
    public CarNotFoundException(Integer id){
        super("Car with id " + id + " not found");
    }
}
