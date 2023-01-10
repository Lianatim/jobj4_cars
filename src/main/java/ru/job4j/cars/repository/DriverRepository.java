package ru.job4j.cars.repository;

import ru.job4j.cars.model.Driver;

import java.util.List;
import java.util.Optional;

public interface DriverRepository {

    Driver create(Driver driver);

    boolean update(Integer id, Driver driver);

    boolean delete(int driverId);

    List<Driver> findAll();

    Optional<Driver> findById(int driverId);
}
