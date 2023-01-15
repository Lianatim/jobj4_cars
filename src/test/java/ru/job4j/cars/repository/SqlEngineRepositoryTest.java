package ru.job4j.cars.repository;
/*
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;
import ru.job4j.cars.model.Engine;

import java.util.List;
import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;

class SqlEngineRepositoryTest {
    private final StandardServiceRegistry registry = new StandardServiceRegistryBuilder()
            .configure().build();
    private final SessionFactory sf = new MetadataSources(registry)
            .buildMetadata().buildSessionFactory();

    private final CrudRepository crudRepository = new SimpleCrudRepository(sf);
    private final EngineRepository engineRepository = new SqlEngineRepository(crudRepository);

    @AfterEach
    public void wipeTable() {
        try (Session session = sf.openSession()) {
            session.beginTransaction();
            List<Engine> result = session.createQuery("From Engine ", Engine.class).list();
            for (Engine e : result) {
                session.delete(e);
            }
            session.getTransaction().commit();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Test
    void whenCreate() {
        Engine engine = new Engine();
        engine.setName("Engine");
        engineRepository.create(engine);
        Optional<Engine> rsl = engineRepository.findById(engine.getId());
        assertThat(rsl.get()).isEqualTo(engine);
    }

    @Test
    void whenUpdate() {
        Engine engine = new Engine();
        engine.setName("Engine");
        Engine engineUpdate = new Engine();
        engineUpdate.setName("Engine");
        engineRepository.create(engine);
        boolean rsl = engineRepository.update(engine.getId(), engineUpdate);
        Optional<Engine> rslUpdate = engineRepository.findById(engine.getId());
        assertThat(rsl).isTrue();
        assertThat(rslUpdate.get().getName()).isEqualTo(engineUpdate.getName());
    }

    @Test
    void whenDelete() {
        Engine engine = new Engine();
        engine.setName("Engine");
        engineRepository.create(engine);
        boolean rsl = engineRepository.delete(engine.getId());
        assertThat(rsl).isTrue();
    }

    @Test
    void whenFindAll() {
        Engine engine = new Engine();
        engine.setName("Engine");
        engineRepository.create(engine);
        List<Engine> rsl = engineRepository.findAll();
        List<Engine> expected = List.of(engine);
        assertThat(rsl).isEqualTo(expected);
    }

    @Test
    void whenFindById() {
        Engine engine = new Engine();
        engine.setName("Engine");
        engineRepository.create(engine);
        Engine rsl = engineRepository.findById(engine.getId()).get();
        assertThat(rsl).isEqualTo(engine);
    }
}

 */