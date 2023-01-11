package ru.job4j.cars.repository;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Repository;
import ru.job4j.cars.model.Post;

import java.util.List;
import java.util.Map;

@Repository
@AllArgsConstructor
public class SqlPostRepository implements PostRepository {
    private static final String FIND_BY_LAST_DAY = "FROM Post WHERE created > CURRENT_DATE - INTERVAL '1 day'";
    private static final String FIND_BY_PHOTO = "FROM Post WHERE photo IS NOT NULL";
    private static final String FIND_BY_MODEL = "FROM Post p JOIN FETCH p.car WHERE p.car.name = :fName";
    private final CrudRepository crudRepository;

    @Override
    public List<Post> findByLastDay() {
        return crudRepository.query(FIND_BY_LAST_DAY, Post.class);
    }

    @Override
    public List<Post> findByPhoto() {
        return crudRepository.query(FIND_BY_PHOTO, Post.class);
    }

    @Override
    public List<Post> findByModel(String key) {
        return crudRepository.query(FIND_BY_MODEL, Post.class, Map.of("fKey", key));
    }
}
