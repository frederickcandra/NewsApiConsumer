package com.newsAPI.ConsumerNewsAPI.component;

import com.newsAPI.ConsumerNewsAPI.model.NewsModel;
import com.newsAPI.ConsumerNewsAPI.repository.NewsRepository;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Service
public class NewsConsumer {

    private final NewsRepository newsRepository;

    public NewsConsumer(NewsRepository newsRepository) {
        this.newsRepository = newsRepository;
    }

    @KafkaListener(topics = "news-topic", groupId = "news-group")
    public void listen(NewsModel news) {
        System.out.println("Received News: " + news.getTitle());
        newsRepository.save(news);
    }
}