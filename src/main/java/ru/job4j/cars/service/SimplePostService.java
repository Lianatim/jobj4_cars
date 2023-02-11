package ru.job4j.cars.service;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import ru.job4j.cars.dto.FileDto;
import ru.job4j.cars.model.Post;
import ru.job4j.cars.model.PriceHistory;
import ru.job4j.cars.repository.PostRepository;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class SimplePostService implements PostService {

    private final PostRepository postRepository;

    private final FileService fileService;

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
    public Post create(Post post, FileDto image, Long newPrice) {
        saveNewFile(post, image);
        setPrice(post, newPrice);
        return postRepository.create(post);
    }

    private void saveNewFile(Post post, FileDto image) {
        var file = fileService.save(image);
        post.setFiles(file);
    }

    @Override
    public List<Post> findAll() {
        return postRepository.findAll();
    }

    @Override
    public Optional<Post> findById(int postId) {
        return postRepository.findById(postId);
    }

    private void setPrice(Post post, Long newPrice) {
        List<PriceHistory> currentPriceHistory = post.getPriceHistoryList();
        PriceHistory priceCar = new PriceHistory();
        if (currentPriceHistory.isEmpty()) {
            priceCar.setBefore(newPrice);
            priceCar.setAfter(newPrice);
            currentPriceHistory.add(priceCar);
            priceCar.setCreated(LocalDateTime.now());
        } else {
            Long lastPrice = currentPriceHistory.get(currentPriceHistory.size() - 1).getAfter();
            priceCar.setBefore(lastPrice);
            priceCar.setAfter(newPrice);
        }
    }

}
