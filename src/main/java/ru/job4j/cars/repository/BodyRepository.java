package ru.job4j.cars.repository;

import ru.job4j.cars.model.Body;

import java.util.List;
import java.util.Optional;

public interface BodyRepository {


    Body create(Body body);

    boolean update(Integer id, Body body);

    boolean delete(int bodyId);

    List<Body> findAll();

    Optional<Body> findById(int bodyId);
}
