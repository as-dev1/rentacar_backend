package com.rent.rentacar.service;

import com.rent.rentacar.exception.custom.UserNotFoundException;
import com.rent.rentacar.model.User;
import com.rent.rentacar.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class UserService {

    private final UserRepository repository;

    public List<User> getAllUsers() {
        return repository.findAll();
    }

    public User getUserById(Integer id) {
        return repository.findById(id).orElseThrow(() -> new UserNotFoundException(id));
    }

    public User createUser(User user) {
        user.setId(null);
        return repository.save(user);
    }

    public User updateUser(Integer id, User user) {
        if(!repository.existsById(id)) {
            throw new UserNotFoundException(id);
        }

        user.setId(id);
        return repository.save(user);
    }

    public String deleteUser(Integer id) {
        if(!repository.existsById(id)) {
            throw new UserNotFoundException(id);
        }
        repository.deleteById(id);
        return "User with id " + id + " has been deleted successfully";
    }
}