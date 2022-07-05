package com.example.blog.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public class ArticleDto {

    private Long id;
    private String title;
    private String content;
    private String poster;
    private String pw;
}
