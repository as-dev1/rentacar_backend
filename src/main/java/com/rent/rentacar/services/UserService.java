package com.rent.rentacar.services;

import com.rent.rentacar.models.User;
import com.rent.rentacar.repositories.UserRepository;
import lombok.RequiredArgsConstructor;

import java.util.List;
import java.util.Optional;

@RequiredArgsConstructor
public class UserService {

    private final UserRepository repository;

    public List<User> getAllUsers() {
        return repository.findAll();
    }

    public Optional<User> getUserById(Integer id) {
        return repository.findById(id);
    }

    public User createUser(User user) {
        return repository.save(user);
    }

    public Optional<User> updateUser(Integer id, User userDetails) {
        return repository.findById(id).map(user -> {
            user.setUsername(userDetails.getUsername());
            user.setPassword(userDetails.getPassword());
            user.setEmail(userDetails.getEmail());
            user.setFirst_name(userDetails.getFirst_name());
            user.setLast_name(userDetails.getLast_name());
            user.setPhone_number(userDetails.getPhone_number());
            return repository.save(user);
        });
    }
}
