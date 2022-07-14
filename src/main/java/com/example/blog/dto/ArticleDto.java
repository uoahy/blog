package com.example.blog.dto;

import com.example.blog.user.User;
import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public class ArticleDto {

    private String title;
    private String content;
    private User poster;
}
