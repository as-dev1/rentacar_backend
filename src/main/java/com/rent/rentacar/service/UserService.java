package com.rent.rentacar.service;

import com.rent.rentacar.exception.UserNotFoundException;
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

    public User updateUser(Integer id, User userDetails) {
        return repository.findById(id).map(user -> {
            user.setUsername(userDetails.getUsername());
            user.setPassword(userDetails.getPassword());
            user.setEmail(userDetails.getEmail());
            user.setFirstName(userDetails.getFirstName());
            user.setLastName(userDetails.getLastName());
            user.setPhoneNumber(userDetails.getPhoneNumber());
            return repository.save(user);
        }).orElseThrow(() -> new UserNotFoundException(id));
    }

    public String deleteUser(Integer id) {
        if(!repository.existsById(id)) {
            throw new UserNotFoundException(id);
        }
        repository.deleteById(id);
        return "User with id " + id + " has been deleted successfully";
    }
}
