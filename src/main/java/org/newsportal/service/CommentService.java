package org.newsportal.service;

import lombok.RequiredArgsConstructor;
import org.newsportal.repository.CommentRepository;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class CommentService {

    private final CommentRepository commentRepository;
}
