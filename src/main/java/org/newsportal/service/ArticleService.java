package org.newsportal.service;

import lombok.RequiredArgsConstructor;
import org.newsportal.dto.ArticleRequest;
import org.newsportal.entity.Article;
import org.newsportal.mapper.ArticleMapper;
import org.newsportal.repository.ArticleRepository;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
@RequiredArgsConstructor
public class ArticleService {

    private final ArticleRepository repository;
    private final ArticleMapper mapper;

    public Long createArticle(ArticleRequest request) {
        var article = mapper.toArticle(request);
        return repository.save(article).getId();
    }

    public List<Article> getAllArticles() {
        return repository.findAll();
    }

    public Article getArticle(Long id) {
        return repository.findById(id).orElseThrow();
    }

    public Article updateArticle(Long id, ArticleRequest request) {
        var articleForUpdate = repository.findById(id).orElseThrow();
        articleForUpdate.setTitle(request.title());
        articleForUpdate.setContent(request.content());
        articleForUpdate.setUrl(request.url());
        articleForUpdate.setThumbnail(request.thumbnail());
        return articleForUpdate;
    }

    public void deleteArticle(Long id) {
        repository.deleteById(id);
    }
}
