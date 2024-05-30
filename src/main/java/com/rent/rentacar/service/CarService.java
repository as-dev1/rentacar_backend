package com.rent.rentacar.service;

import com.rent.rentacar.exception.custom.CarNotFoundException;
import com.rent.rentacar.entity.Car;
import com.rent.rentacar.model.CarModel;
import com.rent.rentacar.repository.CarRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
@RequiredArgsConstructor
public class CarService {

    private final CarRepository repository;

    public List<Car> getAllCars() {
        return repository.findAllByDeletedAtIsNull();
    }

    public Car getCarById(Integer id) {
        return repository.findByIdAndDeletedAtIsNull(id).orElseThrow(() -> new CarNotFoundException(id));
    }

    public Car createCar(Car car) {
        car.setId(null);
        return repository.save(car);
    }

    public Car updateCar(Integer id, CarModel model) {
        Car car = repository.findByIdAndDeletedAtIsNull(id).orElseThrow(() -> new CarNotFoundException(id));
        car.setBrand(model.getBrand());
        car.setModel(model.getModel());
        car.setType(model.getType());
        car.setYear(model.getYear());
        car.setNumberOfSeats(model.getNumberOfSeats());
        car.setHp(model.getHp());
        car.setDescription(model.getDescription());
        car.setPricePerDay(model.getPricePerDay());
        car.setImgPath(model.getImgPath());
        car.setUpdatedAt(LocalDateTime.now());
        return repository.save(car);
    }

    public void deleteCar(Integer id) {
        Car car = repository.findByIdAndDeletedAtIsNull(id).orElseThrow(() -> new CarNotFoundException(id));
        car.setDeletedAt(LocalDateTime.now());
        repository.save(car);}
}
