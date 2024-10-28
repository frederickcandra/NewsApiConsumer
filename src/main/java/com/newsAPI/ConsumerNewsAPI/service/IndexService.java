package com.newsAPI.ConsumerNewsAPI.service;

import com.newsAPI.ConsumerNewsAPI.model.NewsModel;
import jakarta.annotation.PostConstruct;
import org.springframework.data.domain.Sort;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.index.Index;
import org.springframework.stereotype.Service;

@Service
public class IndexService {

    private final MongoTemplate mongoTemplate;

    public IndexService(MongoTemplate mongoTemplate) {
        this.mongoTemplate = mongoTemplate;
    }

    @PostConstruct
    public void createIndexes() {
        mongoTemplate.indexOps(NewsModel.class)
                .ensureIndex(new Index().on("title", Sort.Direction.ASC));
    }
}