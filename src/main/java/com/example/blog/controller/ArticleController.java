package com.example.blog.controller;

import com.example.blog.domain.Article;
import com.example.blog.dto.ArticleDto;
import com.example.blog.repository.ArticleRepository;
import com.example.blog.service.ArticleService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RequiredArgsConstructor
@RestController
@RequestMapping(path = "/api")
public class ArticleController {

    private final ArticleRepository articleRepository;
    private final ArticleService articleService;

    @PostMapping("/articles")
    public Article addNewArticle(@RequestBody Article newArticle) {
        return articleRepository.save(newArticle);
    }

    @GetMapping("/articles")
    public List<Article> getAllArticles() {
        return articleRepository.findAll();
    }

    @GetMapping("/articles/{id}")
    public Article getArticle(@PathVariable Long id) {
        return articleRepository.findById(id).orElseThrow(IllegalArgumentException::new);
    }

    @PutMapping("/articles/{id}")
    public Long editArticle(@PathVariable Long id, @RequestBody ArticleDto articleDto) {
        return articleService.editArticle(id, articleDto);
    }

    @DeleteMapping("/articles/{id}")
    public Long deleteArticle(@PathVariable Long id, @RequestBody Map<String, String> requestBody) {
        String pw = requestBody.get("pw");
        Article article = articleRepository.findById(id).orElseThrow(IllegalArgumentException::new);
        if (pw.equals(article.getPw())) {
            articleRepository.deleteById(id);
            return id;
        } else {
            return -1L;
        }
    }
}
