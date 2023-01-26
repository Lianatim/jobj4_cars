package ru.job4j.cars.repository;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Repository;
import ru.job4j.cars.model.Engine;

import java.util.List;
import java.util.Map;
import java.util.Optional;

@Repository
@AllArgsConstructor
public class SqlEngineRepository implements EngineRepository {

    private static final String UPDATE = "UPDATE Engine SET name = :fName WHERE id = :fId";
    private static final String DELETE = "DELETE FROM Engine WHERE id = :fId";
    private static final String FIND_ALL = "FROM Engine";
    private static final String FIND_BY_ID = "FROM Engine WHERE id = :fId";
    private final CrudRepository crudRepository;

    /**
     * Сохранить в базе.
     *
     * @param engine автомобиль.
     * @return автомобиль с id.
     */
    public Engine create(Engine engine) {
        crudRepository.run(session -> session.persist(engine));
        return engine;
    }

    /**
     * Обновить в базе двигатель.
     *
     * @param engine двигатель.
     */
    @Override
    public boolean update(Integer id, Engine engine) {
        return crudRepository.booleanQuery(UPDATE,
                Map.of("fName", engine.getName(),
                        "fId", id)
        );
    }

    /**
     * Удалить двигатель по id.
     *
     * @param engineId ID
     */
    public boolean delete(int engineId) {
        return crudRepository.booleanQuery(DELETE, Map.of("fId", engineId));
    }

    /**
     * Список всех двигателей
     *
     * @return список двигателей.
     */
    public List<Engine> findAll() {
        return crudRepository.query(FIND_ALL, Engine.class);
    }

    /**
     * Найти двигатель по ID
     *
     * @return двигатель.
     */
    public Optional<Engine> findById(int engineId) {
        return crudRepository.optional(
                FIND_BY_ID, Engine.class,
                Map.of("fId", engineId)
        );
    }
}
