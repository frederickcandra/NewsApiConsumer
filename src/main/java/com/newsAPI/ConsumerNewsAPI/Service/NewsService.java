package com.newsAPI.ConsumerNewsAPI.Service;

import com.newsAPI.ConsumerNewsAPI.model.NewsModel;
import com.newsAPI.ConsumerNewsAPI.repository.NewsRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class NewsService {

    private final NewsRepository newsRepository;

    public NewsService(NewsRepository newsRepository) {
        this.newsRepository = newsRepository;
    }

    // Create
    public NewsModel addNews(NewsModel newsModel) {
        return newsRepository.save(newsModel);
    }

    // Read All
    public List<NewsModel> getAllNews() {
        return newsRepository.findAll();
    }

    // Read by ID
    public Optional<NewsModel> getNewsById(String id) {
        return newsRepository.findById(id);
    }

    // Update
    public NewsModel updateNews(String id, NewsModel updatedNews) {
        return newsRepository.findById(id).map(news -> {
            news.setTitle(updatedNews.getTitle());
            news.setAuthor(updatedNews.getAuthor());
            news.setDescription(updatedNews.getDescription());
            news.setUrl(updatedNews.getUrl());
            news.setUrlToImage(updatedNews.getUrlToImage());
            news.setPublishedAt(updatedNews.getPublishedAt());
            news.setContent(updatedNews.getContent());
            news.setSourceName(updatedNews.getSourceName());
            return newsRepository.save(news);
        }).orElseThrow(() -> new RuntimeException("News not found with id: " + id));
    }

    // Delete
    public void deleteNews(String id) {
        newsRepository.deleteById(id);
    }
}
