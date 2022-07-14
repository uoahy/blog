package com.example.blog.service;

import com.example.blog.domain.Comment;
import com.example.blog.dto.CommentDto;
import com.example.blog.repository.CommentRepository;
import com.example.blog.security.UserDetailsImpl;
import com.example.blog.user.User;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@RequiredArgsConstructor
@Service
public class CommentService {

    private final CommentRepository commentRepository;

    @Transactional
    public Long editComment(Long id, CommentDto commentDto, UserDetailsImpl userDetails) {
        User user = userDetails.getUser();
        Comment comment = commentRepository.findById(id).orElseThrow(IllegalArgumentException::new);
        if (user.equals(comment.getUser())) {
            comment.setComment(commentDto);
            return id;
        } else {
            return -1L;
        }
    }
}
