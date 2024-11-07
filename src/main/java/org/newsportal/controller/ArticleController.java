package org.newsportal.controller;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.newsportal.dto.ArticleRequest;
import org.newsportal.service.ArticleService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping
@RequiredArgsConstructor
public class ArticleController {

    private final ArticleService service;

    @PostMapping
    public ResponseEntity<Long> createArticle(@RequestBody @Valid ArticleRequest request){
        return ResponseEntity.ok(service.createArticle(request));
    }
}
