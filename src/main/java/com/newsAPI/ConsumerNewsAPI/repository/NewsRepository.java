package com.newsAPI.ConsumerNewsAPI.repository;

import com.newsAPI.ConsumerNewsAPI.model.NewsModel;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface NewsRepository extends MongoRepository<NewsModel, String> {
}
