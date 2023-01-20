package ru.job4j.cars.repository;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Repository;
import ru.job4j.cars.model.Post;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Map;

@Repository
@AllArgsConstructor
public class SqlPostRepository implements PostRepository {
    private static final String FIND_BY_LAST_DAY = "FROM Post p JOIN FETCH p.car WHERE p.created BETWEEN :fCreatedBefore AND :fCreatedAfter";
    private static final String FIND_BY_PHOTO = "FROM Post p JOIN FETCH p.car WHERE photo IS NOT NULL";
    private static final String FIND_BY_MODEL = "FROM Post p JOIN FETCH p.car WHERE p.car.name = :fName";
    private static final String FIND_ALL = "FROM Post p JOIN FETCH p.car";
    private final CrudRepository crudRepository;

    @Override
    public List<Post> findByLastDay() {
        LocalDateTime beforePeriod = LocalDateTime.now().minusHours(24);
        LocalDateTime afterPeriod = LocalDateTime.now();
        return crudRepository.query(FIND_BY_LAST_DAY, Post.class,
                Map.of("fCreatedBefore", beforePeriod,
                        "fCreatedAfter", afterPeriod)
        );
    }

    @Override
    public List<Post> findByPhoto() {
        return crudRepository.query(FIND_BY_PHOTO, Post.class);
    }

    @Override
    public List<Post> findByModel(String key) {
        return crudRepository.query(FIND_BY_MODEL, Post.class, Map.of("fName", key));
    }

    @Override
    public Post create(Post post) {
        crudRepository.run(session -> session.persist(post));
        return post;
    }

    @Override
    public List<Post> findAll() {
        return crudRepository.query(FIND_ALL, Post.class);
    }

}
