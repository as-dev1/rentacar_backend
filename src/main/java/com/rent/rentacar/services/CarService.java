package com.rent.rentacar.services;

import com.rent.rentacar.exception.CarNotFoundException;
import com.rent.rentacar.models.Car;
import com.rent.rentacar.repositories.CarRepository;
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
        return repository.save(car);
    }

    public Car updateCar(Integer id, Car carDetails) {
        return repository.findById(id).map(car -> {
            car.setBrand(carDetails.getBrand());
            car.setModel(carDetails.getModel());
            car.setType(carDetails.getType());
            car.setYear(carDetails.getYear());
            car.setNumberOfSeats(carDetails.getNumberOfSeats());
            car.setHp(carDetails.getHp());
            car.setDescription(carDetails.getDescription());
            car.setPricePerDay(carDetails.getPricePerDay());
            car.setImgPath(carDetails.getImgPath());
            return repository.save(car);
        }).orElseThrow(() -> new CarNotFoundException(id));
    }

    public String deleteCar(Integer id) {
        if (!repository.existsById(id)) {
            throw new CarNotFoundException(id);
        }
        repository.deleteById(id);
        return "Car with id " + id + " has been deleted successfully";
    }
}
