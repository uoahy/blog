package com.example.blog.controller;

import com.example.blog.domain.Article;
import com.example.blog.repository.ArticleRepository;
import com.example.blog.service.ArticleService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@AllArgsConstructor
@RestController
@RequestMapping(path="/api")
public class ArticleController {

    private ArticleRepository articleRepository;
    private ArticleService articleService;

    @PostMapping("/articles")
    public Article addNewArticle(@RequestBody Article newArticle) {
        return articleRepository.save(newArticle);
    }

    @GetMapping("/articles")
    public List<Article> getAllArticles() {
        return articleRepository.findAll();
    }

    @DeleteMapping("/articles/{id}")
    public void deleteArticle(@PathVariable Long id) {
        articleRepository.deleteById(id);
    }
}
