package com.rent.rentacar.exception.custom;

public class UserNotFoundException extends NotFoundException {
    public UserNotFoundException(Integer id) {
        super("User with id " + id + " not found");
    }
}
