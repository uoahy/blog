package com.example.blog.service;

import com.example.blog.repository.ArticleRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@AllArgsConstructor
@Service
public class ArticleService {

    private ArticleRepository articleRepository;
}
