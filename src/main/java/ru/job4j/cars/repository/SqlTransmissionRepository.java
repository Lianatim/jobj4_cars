package ru.job4j.cars.repository;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Repository;
import ru.job4j.cars.model.Transmission;

import java.util.List;
import java.util.Map;
import java.util.Optional;

@Repository
@AllArgsConstructor
public class SqlTransmissionRepository implements TransmissionRepository {
    private static final String UPDATE = "UPDATE Transmission SET name = :fName WHERE id = :fId";
    private static final String DELETE = "DELETE FROM Transmission WHERE id = :fId";
    private static final String FIND_ALL = "FROM Transmission";
    private static final String FIND_BY_ID = "FROM Transmission e WHERE e.id = :fId";
    private final CrudRepository crudRepository;

    /**
     * Сохранить в базе.
     *
     * @param transmission автомобиль.
     * @return автомобиль с id.
     */
    public Transmission create(Transmission transmission) {
        crudRepository.run(session -> session.persist(transmission));
        return transmission;
    }

    /**
     * Обновить в базе двигатель.
     *
     * @param transmission двигатель.
     */
    @Override
    public boolean update(Integer id, Transmission transmission) {
        return crudRepository.booleanQuery(UPDATE,
                Map.of("fName", transmission.getName(),
                        "fId", id)
        );
    }

    /**
     * Удалить автомобиль по id.
     *
     * @param transmissionId ID
     */
    public boolean delete(int transmissionId) {
        return crudRepository.booleanQuery(DELETE, Map.of("fId", transmissionId));
    }

    /**
     * Список всех автомобилей
     *
     * @return список автомобилей.
     */
    public List<Transmission> findAll() {
        return crudRepository.query(FIND_ALL, Transmission.class);
    }

    /**
     * Найти автомобиль по ID
     *
     * @return автомобиль.
     */
    public Optional<Transmission> findById(int transmissionId) {
        return crudRepository.optional(
                FIND_BY_ID, Transmission.class,
                Map.of("fId", transmissionId)
        );
    }
}

