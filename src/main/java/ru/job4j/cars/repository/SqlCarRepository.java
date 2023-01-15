package ru.job4j.cars.repository;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Repository;
import ru.job4j.cars.model.Car;

import java.util.List;
import java.util.Map;
import java.util.Optional;

@Repository
@AllArgsConstructor
public class SqlCarRepository implements CarRepository {

    private static final String UPDATE = "UPDATE Car c SET name = :fName, created = :fCreated WHERE c.id = :fId";
    private static final String DELETE = "DELETE FROM Car c WHERE c.id = :fId";
    private static final String FIND_ALL = "FROM Car c JOIN FETCH c.engine";
    private static final String FIND_BY_ID = "FROM Car c JOIN FETCH c.engine WHERE c.id = :fId";
    private final CrudRepository crudRepository;

    /**
     * Сохранить в базе.
     *
     * @param car автомобиль.
     * @return автомобиль с id.
     */
    @Override
    public Car create(Car car) {
        crudRepository.run(session -> session.persist(car));
        return car;
    }

    /**
     * Обновить в базе автомобиль.
     *
     * @param car автомобиль.
     */
    @Override
    public boolean update(Integer id, Car car) {
        return crudRepository.booleanQuery(UPDATE,
                Map.of("fName", car.getName(),
                        "fCreated", car.getCreated(),
                        "fId", id)
        );
    }

    /**
     * Удалить автомобиль по id.
     *
     * @param carId ID
     */
    @Override
    public boolean delete(int carId) {
        return crudRepository.booleanQuery(DELETE, Map.of("fId", carId));
    }

    /**
     * Список всех автомобилей
     *
     * @return список автомобилей.
     */
    @Override
    public List<Car> findAll() {
        return crudRepository.query(FIND_ALL, Car.class);
    }

    /**
     * Найти автомобиль по ID
     *
     * @return автомобиль.
     */
    @Override
    public Optional<Car> findById(int carId) {
        return crudRepository.optional(
                FIND_BY_ID, Car.class,
                Map.of("fId", carId)
        );
    }
}
