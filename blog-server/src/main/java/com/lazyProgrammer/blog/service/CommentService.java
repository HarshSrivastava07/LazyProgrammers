package com.lazyProgrammer.blog.service;

import com.lazyProgrammer.blog.dto.request.CommentRequest;
import com.lazyProgrammer.blog.model.Comment;

import java.util.List;

public interface CommentService {
    List<Comment> getAllCommentByPostId(Long id);
    void save(CommentRequest comment);
}
