package ru.job4j.cars.repository;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;
import ru.job4j.cars.model.User;

import java.util.List;
import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;

class SqlUserRepositoryTest {
    private final StandardServiceRegistry registry = new StandardServiceRegistryBuilder()
            .configure().build();
    private final SessionFactory sf = new MetadataSources(registry)
            .buildMetadata().buildSessionFactory();

    private final CrudRepository crudRepository = new SimpleCrudRepository(sf);
    private final UserRepository userRepository = new SqlUserRepository(crudRepository);

    @AfterEach
    public void wipeTable() {
        Session session = sf.openSession();
        session.beginTransaction();
        session.createQuery("DELETE FROM User").executeUpdate();
        session.getTransaction().commit();
    }

    @Test
    void create() {
        User user = new User();
        user.setLogin("login");
        user.setPassword("password");
        userRepository.create(user);
        Optional<User> rsl = userRepository.findById(user.getId());
        assertThat(rsl.get()).isEqualTo(user);
    }

    @Test
    void update() {
        User user = new User();
        user.setLogin("login");
        user.setPassword("password");
        userRepository.create(user);
        user.setLogin("loginUpd");
        user.setPassword("passwordUpd");
        userRepository.update(user);
        Optional<User> rsl = userRepository.findById(user.getId());
        assertThat(rsl.get().getLogin()).isEqualTo("loginUpd");
    }

    @Test
    void findAllOrderById() {
        User user = new User();
        user.setLogin("login");
        user.setPassword("password");
        userRepository.create(user);
        List<User> rsl = userRepository.findAllOrderById();
        List<User> expected = List.of(user);
        assertThat(rsl).isEqualTo(expected);
    }

    @Test
    void findById() {
        User user = new User();
        user.setLogin("login");
        user.setPassword("password");
        userRepository.create(user);
        User rsl = userRepository.findById(user.getId()).get();
        assertThat(rsl).isEqualTo(user);
    }

    @Test
    void findByLikeLogin() {
        User user = new User();
        user.setLogin("login");
        user.setPassword("password");
        userRepository.create(user);
        List<User> rsl = userRepository.findByLikeLogin("og");
        List<User> expected = List.of(user);
        assertThat(rsl).isEqualTo(expected);
    }

    @Test
    void findByLogin() {
        User user = new User();
        user.setLogin("login");
        user.setPassword("password");
        userRepository.create(user);
        List<User> rsl = userRepository.findByLikeLogin("login");
        List<User> expected = List.of(user);
        assertThat(rsl).isEqualTo(expected);
    }
}