package ru.job4j.cars.repository;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Repository;
import ru.job4j.cars.model.Post;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Map;
import java.util.Optional;

@Repository
@AllArgsConstructor
public class SqlPostRepository implements PostRepository {
    private static final String FIND_BY_LAST_DAY = "FROM Post p JOIN FETCH p.car WHERE p.created BETWEEN :fCreatedBefore AND :fCreatedAfter";
    private static final String FIND_BY_PHOTO = "FROM Post p JOIN FETCH p.car WHERE fileId IS NOT NULL";
    private static final String FIND_BY_MODEL = "FROM Post p JOIN FETCH p.car WHERE p.car.name = :fName";
    private static final String FIND_ALL = "FROM Post p JOIN FETCH p.car JOIN FETCH p.car.engine JOIN FETCH p.car.body JOIN FETCH p.car.transmission";
    private static final String FIND_BY_ID = "FROM Post p JOIN FETCH p.car WHERE p.id = :fId";
    private static final String FIND_BY_SOLD = "FROM Post p JOIN FETCH p.car where p.sold = :fSold";
    private static final String SET_SOLD = "FROM Post p JOIN FETCH p.car SET p.sold = :fSold WHERE p.id = :pId";
    private static final String SET_UNSOLD = "UPDATE Post p JOIN FETCH p.car SET p.sold = :fSold WHERE p.id = :pId";
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

    @Override
    public Optional<Post> findById(int postId) {
        return crudRepository.optional(
                FIND_BY_ID, Post.class,
                Map.of("fId", postId)
        );
    }

    /**
     * Список постов по условию : на продаже или продано.
     * @param sold done
     * @return Список постов по условию : на продаже или продано.
     */
    @Override
    public List<Post> findBySold(boolean sold) {
        return crudRepository.query(FIND_BY_SOLD, Post.class,
                Map.of("fSold", sold)
        );
    }

    /**
     * Установить стутус "Продано" поста по id.
     *
     * @param postId ID
     */
    @Override
    public boolean setSold(int postId) {
        return crudRepository.booleanQuery(
                SET_SOLD,
                Map.of("fSold", true, "fId", postId)
        );
    }


    /**
     * Установить стутус "На продаже" поста по id.
     *
     * @param postId ID
     */
    @Override
    public boolean setUnsold(int postId) {
        return crudRepository.booleanQuery(
                SET_UNSOLD,
                Map.of("fSold", false, "fId", postId)
        );
    }

}
