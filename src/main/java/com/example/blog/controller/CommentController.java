package com.example.blog.controller;

import com.example.blog.domain.Article;
import com.example.blog.domain.Comment;
import com.example.blog.dto.CommentDto;
import com.example.blog.repository.ArticleRepository;
import com.example.blog.repository.CommentRepository;
import com.example.blog.security.UserDetailsImpl;
import com.example.blog.service.CommentService;
import com.example.blog.user.User;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.*;

@RequiredArgsConstructor
@RestController
@RequestMapping(path = "/api")
public class CommentController {

    private final CommentService commentService;
    private final CommentRepository commentRepository;
    private final ArticleRepository articleRepository; // 이게 맞나?

    @PostMapping("articles/{articleId}/comments")
    public Comment addNewComment(@PathVariable Long articleId, @RequestBody CommentDto commentDto, @AuthenticationPrincipal UserDetailsImpl userDetails) {
        Article article = articleRepository.findById(articleId).orElseThrow(IllegalArgumentException::new);
        User user = userDetails.getUser();
        Comment newComment = new Comment(commentDto, article, user);
        return commentRepository.save(newComment);
    }

    @PutMapping("/comments/{id}")
    public Long editComment(@PathVariable Long id, @RequestBody CommentDto commentDto, @AuthenticationPrincipal UserDetailsImpl userDetails) {
        return commentService.editComment(id, commentDto, userDetails);
    }

    @DeleteMapping("/comments/{id}")
    public Long deleteComment(@PathVariable Long id, @AuthenticationPrincipal UserDetailsImpl userDetails) {
        User user = userDetails.getUser();
        Comment comment = commentRepository.findById(id).orElseThrow(IllegalArgumentException::new);
        if (user.equals(comment.getUser())) {
            commentRepository.deleteById(id);
            return id;
        } else {
            return -1L;
        }
    }
}
