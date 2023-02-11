package ru.job4j.cars.repository;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Repository;
import ru.job4j.cars.model.File;

import java.util.Map;
import java.util.Optional;

@AllArgsConstructor
@Repository
public class SqlFileRepository implements FileRepository {

    private static final String FIND_BY_ID = "FROM File WHERE id = :fId";
    private static final String DELETE_BY_ID = "DELETE FROM File WHERE id = :fId";

    private final CrudRepository crudRepository;

    @Override
    public File save(File file) {
        crudRepository.run(session -> session.persist(file));
        return file;
    }

    @Override
    public Optional<File> findById(int id) {
        return crudRepository.optional(
                FIND_BY_ID, File.class,
                Map.of("fId", id)
        );
    }

    @Override
    public boolean deleteById(int id) {
        return crudRepository.booleanQuery(
                DELETE_BY_ID,
                Map.of("fId", id)
        );
    }
}
