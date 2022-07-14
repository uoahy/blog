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
    private User user;
    @OneToMany(mappedBy = "article")
    private List<Comment> comments;

    public Article(String title, String content, User user) {
        this.title = title;
        this.content = content;
        this.user = user;
    }

    public Article(ArticleDto articleDto, User user) {
        title = articleDto.getTitle();
        content = articleDto.getContent();
        this.user = user;
    }

    public void setArticle(ArticleDto articleDto) {
        title = articleDto.getTitle();
        content = articleDto.getContent();
    }
}
