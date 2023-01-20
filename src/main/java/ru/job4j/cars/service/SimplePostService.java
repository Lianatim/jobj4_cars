package ru.job4j.cars.service;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import ru.job4j.cars.model.Post;
import ru.job4j.cars.repository.PostRepository;

import java.util.List;

@Service
@AllArgsConstructor
public class SimplePostService implements PostService {

    private final PostRepository postRepository;

    @Override
    public List<Post> findByLastDay() {
        return postRepository.findByLastDay();
    }

    @Override
    public List<Post> findByPhoto() {
        return postRepository.findByPhoto();
    }

    @Override
    public List<Post> findByModel(String key) {
        return postRepository.findByModel(key);
    }

    @Override
    public Post create(Post post) {
        return postRepository.create(post);
    }

    @Override
    public List<Post> findAll() {
        return postRepository.findAll();
    }

}
