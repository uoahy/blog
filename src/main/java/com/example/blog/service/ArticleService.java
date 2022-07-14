package com.example.blog.service;

import com.example.blog.domain.Article;
import com.example.blog.dto.ArticleDto;
import com.example.blog.repository.ArticleRepository;
import com.example.blog.security.UserDetailsImpl;
import com.example.blog.user.User;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@RequiredArgsConstructor
@Service
public class ArticleService {

    private final ArticleRepository articleRepository;

    @Transactional
    public Long editArticle(Long id, ArticleDto articleDto, UserDetailsImpl userDetails) {
        User user = userDetails.getUser();
        Article article = articleRepository.findById(id).orElseThrow(IllegalArgumentException::new);
        if (user.equals(article.getPoster())) {
            article.setArticle(articleDto);
            return id;
        } else {
            return -1L;
        }
    }
}
