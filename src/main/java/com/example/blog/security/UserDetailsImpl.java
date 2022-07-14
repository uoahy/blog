package com.example.blog.security;

import com.example.blog.domain.Article;
import com.example.blog.domain.Comment;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.User;

import java.util.Collection;
import java.util.List;

public class UserDetailsImpl extends User {

    private final Long id;
    private final List<Article> articles;
    private final List<Comment> comments;

    public UserDetailsImpl(Long id, String username, String password, List<Article> articles, List<Comment> comments, Collection<? extends GrantedAuthority> authorities) {
        super(username, password, authorities);
        this.id = id;
        this.articles = articles;
        this.comments = comments;
    }

    public UserDetailsImpl(com.example.blog.user.User user, Collection<? extends GrantedAuthority> authorities) {
        this(user.getId(), user.getNickname(), user.getPassword(), user.getArticles(), user.getComments(), authorities);
    }

    public Long getId() {
        return id;
    }

    public List<Article> getArticles() {
        return articles;
    }

    public List<Comment> getComments() {
        return comments;
    }

    public com.example.blog.user.User getUser() {
        return new com.example.blog.user.User(getId(), getUsername(), getPassword(), getArticles(), getComments());
    }
}
