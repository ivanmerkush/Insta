package com.netcracker.ivanmerkush.backend.service;

import com.netcracker.ivanmerkush.backend.entity.CommentEntity;

import java.util.List;

public interface CommentService {
    List<CommentEntity> getCommentsForPost(Integer idPost);
    CommentEntity addComment(CommentEntity comment);
    void deleteComment(Integer id);
}
