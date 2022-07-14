package com.example.blog.controller;

import com.example.blog.domain.Article;
import com.example.blog.dto.ArticleDto;
import com.example.blog.repository.ArticleRepository;
import com.example.blog.security.UserDetailsImpl;
import com.example.blog.service.ArticleService;
import com.example.blog.user.User;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequiredArgsConstructor
@RestController
@RequestMapping(path = "/api")
public class ArticleController {

    private final ArticleService articleService;
    private final ArticleRepository articleRepository;

    @PostMapping("/articles")
    public Article addNewArticle(@RequestBody ArticleDto articleDto, @AuthenticationPrincipal UserDetailsImpl userDetails) {
        User user = userDetails.getUser();
        Article newArticle = new Article(articleDto, user);
        return articleRepository.save(newArticle);
    }

    @GetMapping("/articles")
    public List<Article> getAllArticles() {
        return articleRepository.findAllByOrderByCreatedAtDesc();
    }

    @GetMapping("/articles/{id}")
    public Article getArticle(@PathVariable Long id) {
        return articleRepository.findById(id).orElseThrow(IllegalArgumentException::new);
    }

    @PutMapping("/articles/{id}")
    public Long editArticle(@PathVariable Long id, @RequestBody ArticleDto articleDto, @AuthenticationPrincipal UserDetailsImpl userDetails) {
        return articleService.editArticle(id, articleDto, userDetails);
    }

    @DeleteMapping("/articles/{id}")
    public Long deleteArticle(@PathVariable Long id, @AuthenticationPrincipal UserDetailsImpl userDetails) {
        User user = userDetails.getUser();
        Article article = articleRepository.findById(id).orElseThrow(IllegalArgumentException::new);
        if (user.equals(article.getPoster())) {
            articleRepository.deleteById(id);
            return id;
        } else {
            return -1L;
        }
    }
}
