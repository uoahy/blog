package com.example.blog.user;

import com.example.blog.domain.Article;
import com.example.blog.domain.Comment;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Entity
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String nickname;
    private String password;
    @OneToMany(mappedBy = "user")
    private List<Article> articles;
    @OneToMany(mappedBy = "user")
    private List<Comment> comments;
}
