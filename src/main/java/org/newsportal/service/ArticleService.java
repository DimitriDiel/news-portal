package org.newsportal.service;

import lombok.RequiredArgsConstructor;
import org.newsportal.dto.ArticleRequest;
import org.newsportal.mapper.ArticleMapper;
import org.newsportal.repository.ArticleRepository;
import org.springframework.stereotype.Service;


@Service
@RequiredArgsConstructor
public class ArticleService {

    private final ArticleRepository repository;
    private final ArticleMapper mapper;

    public Long createArticle(ArticleRequest request) {
         var article = mapper.toArticle(request);
        return repository.save(article).getId();
    }

}
