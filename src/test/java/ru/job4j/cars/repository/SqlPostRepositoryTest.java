package ru.job4j.cars.repository;

/*
import org.hibernate.SessionFactory;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import ru.job4j.cars.model.Car;
import ru.job4j.cars.model.Engine;
import ru.job4j.cars.model.Post;
import ru.job4j.cars.model.User;

import java.time.LocalDateTime;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class SqlPostRepositoryTest {

    private final StandardServiceRegistry registry = new StandardServiceRegistryBuilder()
            .configure().build();
    private final SessionFactory sf = new MetadataSources(registry)
            .buildMetadata().buildSessionFactory();

    private final CrudRepository crudRepository = new SimpleCrudRepository(sf);
    private final PostRepository postRepository = new SqlPostRepository(crudRepository);
    private final CarRepository carRepository = new SqlCarRepository(crudRepository);
    private final EngineRepository engineRepository = new SqlEngineRepository(crudRepository);
    private final UserRepository userRepository = new SqlUserRepository(crudRepository);
    private Post post;
    private Car car;

    @BeforeEach
    public void addInTable() {
        post = new Post();
        post.setDescription("Description");
        car = new Car();
        Engine engine = new Engine();
        engine.setName("Engine");
        engineRepository.create(engine);
        car.setName("Car");
        car.setEngine(engine);
        car.setCreated(LocalDateTime.now());
        carRepository.create(car);
        post.setCar(car);
        post.setFileId(1);
        User user = new User();
        user.setLogin("Login5");
        user.setPassword("Password5");
        post.setUser(user);
        post.setCreated(LocalDateTime.now());
        userRepository.create(user);
        postRepository.create(post);
    }

    @Test
    void whenFindByLastDay() {
        List<Post> expected = List.of(post);
        List<Post> rsl = postRepository.findByLastDay();
        assertThat(rsl).isEqualTo(expected);
    }

    @Test
    void whenFindByPhoto() {
        List<Post> expected = List.of(post);
        List<Post> rsl = postRepository.findByPhoto();
        assertThat(rsl).isEqualTo(expected);
    }

    @Test
    void whenFindByModel() {
        List<Post> rsl = postRepository.findByModel(car.getName());
        List<Post> expected = List.of(post);
        assertThat(rsl).isEqualTo(expected);
    }

    @Test
    void whenFindAll() {
        Post postSec = new Post();
        postSec.setDescription("Description2");
        car = new Car();
        Engine engine = new Engine();
        engine.setName("Engine2");
        engineRepository.create(engine);
        car.setName("Car2");
        car.setEngine(engine);
        car.setCreated(LocalDateTime.now());
        carRepository.create(car);
        postSec.setCar(car);
        postSec.setFileId(1);
        User user = new User();
        user.setLogin("Login5");
        user.setPassword("Password5");
        postSec.setUser(user);
        postSec.setCreated(LocalDateTime.now());
        userRepository.create(user);
        postRepository.create(postSec);
        List<Post> rsl = postRepository.findAll();
        List<Post> expected = List.of(post, postSec);
        assertThat(rsl).isEqualTo(expected);
    }
}*/
