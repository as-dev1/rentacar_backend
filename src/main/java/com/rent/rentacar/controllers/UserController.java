package com.rent.rentacar.controllers;

import com.rent.rentacar.models.User;
import com.rent.rentacar.services.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "/user")
@RequiredArgsConstructor
public class UserController {
    private final UserService service;

    @GetMapping
    public List<User> getUsers() {
        return service.getAllUsers();
    }

    @GetMapping(path = "/{id}")
    public User getUserById(@PathVariable Integer id) {
        return service.getUserById(id);
    }

    @PostMapping
    public User createUser(@RequestBody User user) {
        return service.createUser(user);
    }

    @PutMapping(path = "/{id}")
    public User updateUser(@PathVariable Integer id, @RequestBody User user) {
        return  service.updateUser(id,user);
    }

    @DeleteMapping(path = "/{id}")
    public String deleteUser(@PathVariable Integer id) {
        return service.deleteUser(id);
    }
}
