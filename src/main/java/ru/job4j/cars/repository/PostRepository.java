package ru.job4j.cars.repository;

import ru.job4j.cars.model.Post;

import java.util.List;
import java.util.Optional;

public interface PostRepository {

    List<Post> findByLastDay();
    List<Post> findByPhoto();
    List<Post> findByModel(String key);

    Post create(Post post);
    List<Post> findAll();

    Optional<Post> findById(int postId);

}
