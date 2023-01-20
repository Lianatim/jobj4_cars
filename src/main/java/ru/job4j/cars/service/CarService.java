package ru.job4j.cars.service;

import ru.job4j.cars.model.Car;

import java.util.List;
import java.util.Optional;


public interface CarService {

    Car create(Car car);

    boolean update(Integer id, Car car);

    boolean delete(int carId);

    List<Car> findAll();

    Optional<Car> findById(int carId);
}
