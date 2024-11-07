package org.newsportal.mapper;

import jakarta.validation.Valid;
import org.newsportal.dto.ArticleRequest;
import org.newsportal.entity.Article;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
public class ArticleMapper {

    public Article toArticle(@Valid ArticleRequest request) {
        return Article.builder()
                .title(request.title())
                .author(request.author())
                .content(request.content())
                .url(request.url())
                .thumbnail(request.thumbnail())
                .date(LocalDateTime.now())
                .build();
    }

}
