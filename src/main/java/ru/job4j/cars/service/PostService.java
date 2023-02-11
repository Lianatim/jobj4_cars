package ru.job4j.cars.service;

import ru.job4j.cars.dto.FileDto;
import ru.job4j.cars.model.Post;

import java.util.List;
import java.util.Optional;

public interface PostService {

    List<Post> findByLastDay();

    List<Post> findByPhoto();

    List<Post> findByModel(String key);

    Post create(Post post, FileDto image, Long newPrice);

    List<Post> findAll();
    Optional<Post> findById(int postId);
}
