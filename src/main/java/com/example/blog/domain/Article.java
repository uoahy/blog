package com.example.blog.domain;

import com.example.blog.dto.ArticleDto;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@NoArgsConstructor
@Getter
@Entity
public class Article extends BaseTimeEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String title;
    private String content;
    private String poster;
    private String pw;

    public Article(String title, String content, String poster, String pw) {
        this.title = title;
        this.content = content;
        this.poster = poster;
        this.pw = pw;
    }

    public Article(ArticleDto articleDto) {
        this.title = articleDto.getTitle();
        this.content = articleDto.getContent();
        this.poster = articleDto.getPoster();
        this.pw = articleDto.getPw();
    }

    public void setArticle(ArticleDto articleDto) {
        this.title = articleDto.getTitle();
        this.content = articleDto.getContent();
        this.poster = articleDto.getPoster();
        this.pw = articleDto.getPw();
    }
}
