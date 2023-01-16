package ru.job4j.cars.repository;

import org.hibernate.SessionFactory;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.junit.jupiter.api.Test;
import ru.job4j.cars.model.Car;
import ru.job4j.cars.model.Engine;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;

class SqlCarRepositoryTest {

    private final StandardServiceRegistry registry = new StandardServiceRegistryBuilder()
            .configure().build();
    private final SessionFactory sf = new MetadataSources(registry)
            .buildMetadata().buildSessionFactory();

    private final CrudRepository crudRepository = new SimpleCrudRepository(sf);
    private final CarRepository carRepository = new SqlCarRepository(crudRepository);
    private final EngineRepository engineRepository = new SqlEngineRepository(crudRepository);

    @Test
    void whenCreateCar() {
        Engine engine = new Engine();
        engine.setName("Engine");
        Car car = new Car();
        car.setName("Car");
        car.setEngine(engine);
        car.setCreated(LocalDateTime.now());
        engineRepository.create(engine);
        carRepository.create(car);
        Optional<Car> rsl = carRepository.findById(car.getId());
        assertThat(rsl.get()).isEqualTo(car);
    }

    @Test
    void whenUpdateCar() {
        Engine engine = new Engine();
        engine.setName("Engine");
        Car car = new Car();
        car.setName("Car");
        car.setEngine(engine);
        car.setCreated(LocalDateTime.now());
        engineRepository.create(engine);
        carRepository.create(car);
        Car carUpdate = new Car();
        carUpdate.setName("UpdatedCar");
        carUpdate.setCreated(LocalDateTime.now());
        boolean rsl = carRepository.update(car.getId(), carUpdate);
        Optional<Car> rslCar = carRepository.findById(car.getId());
        assertThat(rsl).isTrue();
        assertThat(rslCar.get().getName()).isEqualTo(carUpdate.getName());
    }

    @Test
    void whenDelete() {
        Engine engine = new Engine();
        engine.setName("Engine");
        Car car = new Car();
        car.setName("Car");
        car.setEngine(engine);
        car.setCreated(LocalDateTime.now());
        engineRepository.create(engine);
        carRepository.create(car);
        boolean rsl = carRepository.delete(car.getId());
        assertThat(rsl).isTrue();
    }

    @Test
    void whenFindAll() {
        Engine engine = new Engine();
        engine.setName("Engine");
        Car car = new Car();
        car.setName("Car");
        car.setEngine(engine);
        car.setCreated(LocalDateTime.now());
        engineRepository.create(engine);
        carRepository.create(car);
        Engine engine1 = new Engine();
        engine1.setName("Engine");
        Car car1 = new Car();
        car1.setName("Car");
        car1.setEngine(engine);
        car1.setCreated(LocalDateTime.now());
        engineRepository.create(engine1);
        carRepository.create(car1);
        List<Car> expected = List.of(car, car1);
        List<Car> rsl = carRepository.findAll();
        assertThat(rsl).isEqualTo(expected);
    }

    @Test
    void findById() {
        Engine engine = new Engine();
        engine.setName("Engine");
        Car car = new Car();
        car.setName("Car");
        car.setEngine(engine);
        car.setCreated(LocalDateTime.now());
        engineRepository.create(engine);
        carRepository.create(car);
        Car rsl = carRepository.findById(car.getId()).get();
        assertThat(rsl).isEqualTo(car);
    }
}