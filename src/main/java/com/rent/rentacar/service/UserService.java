package com.rent.rentacar.service;

import com.rent.rentacar.exception.custom.UserNotFoundException;
import com.rent.rentacar.entity.User;
import com.rent.rentacar.model.UserModel;
import com.rent.rentacar.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
@RequiredArgsConstructor
public class UserService {

    private final UserRepository repository;

    public List<User> getAllUsers() {
        return repository.findAllByDeletedAtIsNull();
    }

    public User getUserById(Integer id) {
        return repository.findByIdAndDeletedAtIsNull(id).orElseThrow(() -> new UserNotFoundException(id));
    }

    public User createUser(User user) {
        user.setId(null);
        return repository.save(user);
    }

    public User updateUser(Integer id, UserModel model) {
        User user = repository.findByIdAndDeletedAtIsNull(id).orElseThrow(() -> new UserNotFoundException(id));
        user.setUsername(model.getUsername());
        user.setPassword(model.getPassword());
        user.setEmail(model.getEmail());
        user.setFirstName(model.getFirstName());
        user.setLastName(model.getLastName());
        user.setPhoneNumber(model.getPhoneNumber());
        user.setUpdatedAt(LocalDateTime.now());
        return repository.save(user);
    }

    public void deleteUser(Integer id) {
        User user = repository.findByIdAndDeletedAtIsNull(id).orElseThrow(() -> new UserNotFoundException(id));
        user.setDeletedAt(LocalDateTime.now());
        repository.save(user);
    }
}