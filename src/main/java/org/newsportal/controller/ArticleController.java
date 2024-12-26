package org.newsportal.controller;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.newsportal.dto.ArticleRequest;
import org.newsportal.entity.Article;
import org.newsportal.service.ArticleService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/articles")
@RequiredArgsConstructor
public class ArticleController {

    private final ArticleService service;

    @PostMapping("/create")
    public ResponseEntity<Long> createArticle(@RequestBody @Valid ArticleRequest request){
        return ResponseEntity.ok(service.createArticle(request));
    }

    @GetMapping
    public ResponseEntity<List<Article>> getAllArticles(){
        return ResponseEntity.ok(service.getAllArticles());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Article> getArticle(@PathVariable Long id){
        return ResponseEntity.ok(service.getArticle(id));
    }

    @PutMapping("/{id}")
    public ResponseEntity<Article> updateArticle(@PathVariable Long id, @RequestBody @Valid ArticleRequest request){
        return ResponseEntity.ok(service.updateArticle(id, request));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteArticle(@PathVariable Long id){
        service.deleteArticle(id);
        return ResponseEntity.noContent().build();
    }
}
