package com.rent.rentacar.service;

import com.rent.rentacar.exception.CarNotFoundException;
import com.rent.rentacar.model.Car;
import com.rent.rentacar.repository.CarRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class CarService {

    private final CarRepository repository;

    public List<Car> getAllCars() {
        return repository.findAll();
    }

    public Car getCarById(Integer id) {
        return repository.findById(id).orElseThrow(() -> new CarNotFoundException(id));
    }

    public Car createCar(Car car) {
        car.setId(null);
        return repository.save(car);
    }

    public Car updateCar(Integer id, Car car) {
        if (!repository.existsById(id)) {
            throw new CarNotFoundException(id);
        }
        car.setId(id);
        return repository.save(car);
    }

    public String deleteCar(Integer id) {
        if (!repository.existsById(id)) {
            throw new CarNotFoundException(id);
        }
        repository.deleteById(id);
        return "Car with id " + id + " has been deleted successfully";
    }
}
