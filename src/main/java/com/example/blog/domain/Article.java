package com.example.blog.domain;

import com.example.blog.dto.ArticleDto;
import com.example.blog.user.User;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

@NoArgsConstructor
@Getter
@Entity
public class Article extends BaseTimeEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String title;
    private String content;
    @ManyToOne
    private User poster;
    @OneToMany
    private List<Comment> comments;

    public Article(String title, String content, User poster) {
        this.title = title;
        this.content = content;
        this.poster = poster;
    }

    public Article(ArticleDto articleDto, User poster) {
        title = articleDto.getTitle();
        content = articleDto.getContent();
        this.poster = poster;
    }

    public void setArticle(ArticleDto articleDto) {
        title = articleDto.getTitle();
        content = articleDto.getContent();
    }
}
