package com.rent.rentacar.exception.custom;

public class ReviewNotFoundException extends NotFoundException{
    public ReviewNotFoundException(Integer id){
        super("Review with id " + id + " not found");
    }
}

