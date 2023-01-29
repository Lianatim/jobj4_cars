package ru.job4j.cars.repository;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Repository;
import ru.job4j.cars.model.Driver;
import ru.job4j.cars.model.User;

import java.util.List;
import java.util.Map;
import java.util.Optional;

@Repository
@AllArgsConstructor
public class SqlDriverRepository implements DriverRepository {

    private static final String UPDATE = "UPDATE Driver SET name = :fName WHERE id = :fId";
    private static final String DELETE = "DELETE FROM Driver WHERE id = :fId";
    private static final String FIND_ALL = "FROM Driver d JOIN FETCH d.user";
    private static final String FIND_BY_ID = "FROM Driver d JOIN FETCH d.user WHERE d.id = :fId";
    private static final String FIND_BY_USER = "FROM Driver d JOIN FETCH d.user WHERE d.user = :fUser";
    private final CrudRepository crudRepository;

    /**
     * Сохранить в базе.
     *
     * @param driver водитель.
     * @return водитель с id.
     */
    @Override
    public Driver create(Driver driver) {
        crudRepository.run(session -> session.persist(driver));
        return driver;
    }

    /**
     * Обновить в базе водителя.
     *
     * @param driver водитель.
     */
    @Override
    public boolean update(Integer id, Driver driver) {
        return crudRepository.booleanQuery(UPDATE,
                Map.of("fName", driver.getName(),
                        "fId", id)
        );
    }

    /**
     * Удалить водителя по id.
     *
     * @param driverId ID
     */
    @Override
    public boolean delete(int driverId) {
        return crudRepository.booleanQuery(DELETE, Map.of("fId", driverId));
    }

    /**
     * Список всех водителей
     *
     * @return список водителей.
     */
    @Override
    public List<Driver> findAll() {
        return crudRepository.query(FIND_ALL, Driver.class);
    }

    /**
     * Найти водителя по ID
     *
     * @return водитель.
     */
    @Override
    public Optional<Driver> findById(int driverId) {
        return crudRepository.optional(
                FIND_BY_ID, Driver.class,
                Map.of("fId", driverId)
        );
    }

    @Override
    public Optional<Driver> findByUser(User user) {
        return crudRepository.optional(
                FIND_BY_USER, Driver.class,
                Map.of("fUser", user)
        );
    }
}
