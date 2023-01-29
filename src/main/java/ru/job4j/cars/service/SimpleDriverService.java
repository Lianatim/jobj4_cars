package ru.job4j.cars.service;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import ru.job4j.cars.model.Driver;
import ru.job4j.cars.model.User;
import ru.job4j.cars.repository.DriverRepository;

import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class SimpleDriverService implements DriverService {

    private final DriverRepository driverRepository;

    @Override
    public Driver create(Driver driver) {
        return driverRepository.create(driver);
    }

    @Override
    public boolean update(Integer id, Driver driver) {
        return driverRepository.update(id, driver);
    }

    @Override
    public boolean delete(int driverId) {
        return driverRepository.delete(driverId);
    }

    @Override
    public List<Driver> findAll() {
        return driverRepository.findAll();
    }

    @Override
    public Optional<Driver> findById(int driverId) {
        return driverRepository.findById(driverId);
    }

    @Override
    public Optional<Driver> findByUser(User user) {
        return driverRepository.findByUser(user);
    }

}
