package ru.job4j.cars.service;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Repository;
import ru.job4j.cars.model.Engine;
import ru.job4j.cars.repository.EngineRepository;

import java.util.List;
import java.util.Optional;

@Repository
@AllArgsConstructor
public class SimpleEngineService implements EngineService {

    private final EngineRepository engineRepository;

    @Override
    public Engine create(Engine engine) {
        return engineRepository.create(engine);
    }

    @Override
    public boolean update(Integer id, Engine engine) {
        return  engineRepository.update(id, engine);
    }

    @Override
    public boolean delete(int engineId) {
        return engineRepository.delete(engineId);
    }

    @Override
    public List<Engine> findAll() {
        return engineRepository.findAll();
    }

    public Optional<Engine> findById(int engineId) {
        return engineRepository.findById(engineId);
    }
}