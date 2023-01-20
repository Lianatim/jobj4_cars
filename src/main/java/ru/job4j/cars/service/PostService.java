package ru.job4j.cars.service;

import ru.job4j.cars.model.Post;

import java.util.List;

public interface PostService {

    List<Post> findByLastDay();

    List<Post> findByPhoto();

    List<Post> findByModel(String key);

    Post create(Post post);

    List<Post> findAll();
}
