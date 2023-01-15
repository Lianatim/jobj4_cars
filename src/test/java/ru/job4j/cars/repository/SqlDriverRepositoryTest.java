package ru.job4j.cars.repository;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;
import ru.job4j.cars.model.Driver;
import ru.job4j.cars.model.User;

import java.util.List;
import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;

class SqlDriverRepositoryTest {

    private final StandardServiceRegistry registry = new StandardServiceRegistryBuilder()
            .configure().build();
    private final SessionFactory sf = new MetadataSources(registry)
            .buildMetadata().buildSessionFactory();

    private final CrudRepository crudRepository = new SimpleCrudRepository(sf);
    private final DriverRepository driverRepository = new SqlDriverRepository(crudRepository);
    private final UserRepository userRepository = new SqlUserRepository(crudRepository);

    @AfterEach
    public void wipeTable() {
        Session session = sf.openSession();
        session.beginTransaction();
        session.createQuery("DELETE FROM Driver").executeUpdate();
        session.createQuery("DELETE FROM User").executeUpdate();
        session.getTransaction().commit();
    }

    @Test
    void whenCreate() {
        User user = new User();
        Driver driver = new Driver();
        driver.setName("Driver");
        user.setPassword("Password3");
        user.setLogin("Login3");
        driver.setUser(user);
        userRepository.create(user);
        driverRepository.create(driver);
        Optional<Driver> rsl = driverRepository.findById(driver.getId());
        assertThat(rsl.get()).isEqualTo(driver);
    }

    @Test
    void whenUpdate() {
        User user = new User();
        Driver driver = new Driver();
        driver.setName("Driver");
        user.setPassword("Password3");
        user.setLogin("Login3");
        driver.setUser(user);
        Driver driverUpdate = new Driver();
        driverUpdate.setName("Updated");
        userRepository.create(user);
        driverRepository.create(driver);
        boolean rsl = driverRepository.update(driver.getId(), driverUpdate);
        Optional<Driver> rslUpdate = driverRepository.findById(driver.getId());
        assertThat(rsl).isTrue();
        assertThat(rslUpdate.get().getName()).isEqualTo(driverUpdate.getName());
    }

    @Test
    void whenDelete() {
        User user = new User();
        Driver driver = new Driver();
        driver.setName("Driver");
        user.setPassword("Password3");
        user.setLogin("Login3");
        driver.setUser(user);
        userRepository.create(user);
        driverRepository.create(driver);
        boolean rsl = driverRepository.delete(driver.getId());
        assertThat(rsl).isTrue();
    }

    @Test
    void whenFindAll() {
        User user = new User();
        Driver driver = new Driver();
        driver.setName("Driver");
        user.setPassword("Password3");
        user.setLogin("Login3");
        driver.setUser(user);
        userRepository.create(user);
        driverRepository.create(driver);
        List<Driver> rsl = driverRepository.findAll();
        List<Driver> expected = List.of(driver);
        assertThat(rsl).isEqualTo(expected);
    }

    @Test
    void whenFindById() {
        User user = new User();
        Driver driver = new Driver();
        driver.setName("Driver");
        user.setPassword("Password3");
        user.setLogin("Login3");
        driver.setUser(user);
        userRepository.create(user);
        driverRepository.create(driver);
        Driver rsl = driverRepository.findById(driver.getId()).get();
        assertThat(rsl).isEqualTo(driver);
    }
}