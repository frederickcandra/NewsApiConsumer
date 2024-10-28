package com.newsAPI.ConsumerNewsAPI.controller;

import com.newsAPI.ConsumerNewsAPI.Service.NewsService;
import com.newsAPI.ConsumerNewsAPI.model.NewsModel;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/news")
public class NewsController {

    private final NewsService newsService;

    public NewsController(NewsService newsService) {
        this.newsService = newsService;
    }

    @PostMapping("/add")
    public ResponseEntity<NewsModel> addNews(@RequestBody NewsModel newsModel) {
        return ResponseEntity.ok(newsService.addNews(newsModel));
    }

    @GetMapping("/allNews")
    public List<NewsModel> getAllNews() {
        return newsService.getAllNews();
    }

    @GetMapping("/get/{id}")
    public ResponseEntity<NewsModel> getNewsById(@PathVariable String id) {
        return newsService.getNewsById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<NewsModel> updateNews(@PathVariable String id, @RequestBody NewsModel updatedNews) {
        return ResponseEntity.ok(newsService.updateNews(id, updatedNews));
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Void> deleteNews(@PathVariable String id) {
        newsService.deleteNews(id);
        return ResponseEntity.noContent().build();
    }
}