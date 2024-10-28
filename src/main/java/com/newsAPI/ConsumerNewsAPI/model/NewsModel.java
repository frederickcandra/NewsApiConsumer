package com.newsAPI.ConsumerNewsAPI.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Document(collection = "news") // Nama koleksi di MongoDB

public class NewsModel {

    @Id
    private String id; //  String untuk MongoDB

    private String author;
    private String title;
    private String description;
    private String url;
    private String urlToImage;
    private String publishedAt;
    private String content;
    private String sourceName;

    public NewsModel(String author, String title, String description, String url, String urlToImage, String publishedAt, String content, String sourceName) {
        this.author = author;
        this.title = title;
        this.description = description;
        this.url = url;
        this.urlToImage = urlToImage;
        this.publishedAt = publishedAt;
        this.content = content;
        this.sourceName = sourceName;
    }
}
