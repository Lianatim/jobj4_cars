package ru.job4j.cars.service;

import ru.job4j.cars.model.Transmission;

import java.util.List;
import java.util.Optional;

public interface TransmissionService {

    Transmission create(Transmission transmission);

    boolean update(Integer id, Transmission transmission);

    boolean delete(int transmissionId);

    List<Transmission> findAll();

    Optional<Transmission> findById(int transmissionId);
}
