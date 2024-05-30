package com.rent.rentacar.controller;

import com.rent.rentacar.entity.User;
import com.rent.rentacar.model.UserModel;
import com.rent.rentacar.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "/api/user")
@CrossOrigin("http://localhost:5173")
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
    public User updateUser(@PathVariable Integer id, @RequestBody UserModel user) {
        return  service.updateUser(id,user);
    }

    @DeleteMapping(path = "/{id}")
    @ResponseStatus(code = HttpStatus.NO_CONTENT)
    public void deleteUser(@PathVariable Integer id) {
        service.deleteUser(id);
    }
}
