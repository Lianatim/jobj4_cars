package ru.job4j.cars.repository;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Repository;
import ru.job4j.cars.model.Body;

import java.util.List;
import java.util.Map;
import java.util.Optional;

@Repository
@AllArgsConstructor
public class SqlBodyRepository implements BodyRepository {

    private static final String UPDATE = "UPDATE Body SET name = :fName WHERE id = :fId";
    private static final String DELETE = "DELETE FROM Body WHERE id = :fId";
    private static final String FIND_ALL = "FROM Body";
    private static final String FIND_BY_ID = "FROM Body e WHERE e.id = :fId";
    private final CrudRepository crudRepository;

    /**
     * Сохранить в базе.
     *
     * @param body автомобиль.
     * @return автомобиль с id.
     */
    public Body create(Body body) {
        crudRepository.run(session -> session.persist(body));
        return body;
    }

    /**
     * Обновить в базе двигатель.
     *
     * @param body двигатель.
     */
    @Override
    public boolean update(Integer id, Body body) {
        return crudRepository.booleanQuery(UPDATE,
                Map.of("fName", body.getName(),
                        "fId", id)
        );
    }

    /**
     * Удалить автомобиль по id.
     *
     * @param bodyId ID
     */
    public boolean delete(int bodyId) {
        return crudRepository.booleanQuery(DELETE, Map.of("fId", bodyId));
    }

    /**
     * Список всех автомобилей
     *
     * @return список автомобилей.
     */
    public List<Body> findAll() {
        return crudRepository.query(FIND_ALL, Body.class);
    }

    /**
     * Найти автомобиль по ID
     *
     * @return автомобиль.
     */
    public Optional<Body> findById(int bodyId) {
        return crudRepository.optional(
                FIND_BY_ID, Body.class,
                Map.of("fId", bodyId)
        );
    }
}
