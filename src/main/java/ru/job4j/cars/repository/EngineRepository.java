package ru.job4j.cars.repository;

import ru.job4j.cars.model.Engine;

import java.util.List;
import java.util.Optional;

public interface EngineRepository {

    Engine create(Engine engine);

    boolean delete(int engineId);

    boolean update(Integer id, Engine engine);

    List<Engine> findAll();

    Optional<Engine> findById(int engineId);

}
