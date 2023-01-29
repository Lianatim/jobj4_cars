package ru.job4j.cars.service;

import ru.job4j.cars.model.Driver;
import ru.job4j.cars.model.User;

import java.util.List;
import java.util.Optional;

public interface DriverService {

    Driver create(Driver driver);

    boolean update(Integer id, Driver driver);

    boolean delete(int driverId);

    List<Driver> findAll();

    Optional<Driver> findById(int driverId);

    Optional<Driver> findByUser(User user);
}
