package ru.job4j.cars.service;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Repository;
import ru.job4j.cars.model.Transmission;
import ru.job4j.cars.repository.TransmissionRepository;

import java.util.List;
import java.util.Optional;

@Repository
@AllArgsConstructor
public class SimpleTransmissionService implements TransmissionService {

    private final TransmissionRepository transmissionRepository;

    @Override
    public Transmission create(Transmission transmission) {
        return transmissionRepository.create(transmission);
    }

    @Override
    public boolean update(Integer id, Transmission transmission) {
        return transmissionRepository.update(id, transmission);
    }

    @Override
    public boolean delete(int transmissionId) {
        return transmissionRepository.delete(transmissionId);
    }

    @Override
    public List<Transmission> findAll() {
        return transmissionRepository.findAll();
    }

    @Override
    public Optional<Transmission> findById(int transmissionId) {
        return transmissionRepository.findById(transmissionId);
    }
}