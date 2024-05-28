package com.rent.rentacar.controller;

import com.rent.rentacar.model.Car;
import com.rent.rentacar.service.CarService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "/api/car")
@CrossOrigin("http://localhost:5173")
@RequiredArgsConstructor
public class CarController {

    private final CarService service;

    @GetMapping
    public List<Car> getAll() {
        return service.getAllCars();
    }

    @GetMapping(path = "/{id}")
    public Car getCarById(@PathVariable Integer id) {
        return service.getCarById(id);
    }

    @PostMapping
    public Car createCar(@RequestBody Car car) {
        return service.createCar(car);
    }

    @PutMapping(path = "/{id}")
    public Car updateCar(@PathVariable Integer id, @RequestBody Car car) {
        return service.updateCar(id, car);
    }

    @DeleteMapping(path = "/{id}")
    public String deleteCar(@PathVariable Integer id) {
        return service.deleteCar(id);
    }
}