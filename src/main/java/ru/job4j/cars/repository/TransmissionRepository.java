package ru.job4j.cars.repository;

import ru.job4j.cars.model.Transmission;

import java.util.List;
import java.util.Optional;

public interface TransmissionRepository {

    Transmission create(Transmission transmission);

    boolean update(Integer id, Transmission transmission);

    boolean delete(int transmissionId);

    List<Transmission> findAll();

    Optional<Transmission> findById(int transmissionId);
}

