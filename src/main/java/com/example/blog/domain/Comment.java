package com.example.blog.domain;

import com.example.blog.dto.CommentDto;
import com.example.blog.user.User;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@NoArgsConstructor
@Getter
@Entity
public class Comment extends BaseTimeEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String content;
    @ManyToOne
    private Article article;
    @ManyToOne
    private User user;

    public Comment(String content, Article article, User user) {
        this.content = content;
        this.article = article;
        this.user = user;
    }

    public Comment(CommentDto commentDto, Article article, User user) {
        content = commentDto.getContent();
        this.article = article;
        this.user = user;
    }

    public void setComment(CommentDto commentDto) {
        content = commentDto.getContent();
    }
}
