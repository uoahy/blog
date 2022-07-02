package com.example.blog.dto;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor
@Getter
public class ArticleDto {

    private Long id;
    private String title;
    private String content;
    private String poster;
    private String pw;
}
