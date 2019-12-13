package com.netcracker.ivanmerkush.backend.service.impl;

import com.netcracker.ivanmerkush.backend.entity.CommentEntity;
import com.netcracker.ivanmerkush.backend.repository.CommentRepository;
import com.netcracker.ivanmerkush.backend.service.CommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class CommentServiceImpl implements CommentService {
    @Autowired
    CommentRepository commentRepository;

    @Override
    public List<CommentEntity> getCommentsForPost(Integer id) {
        return commentRepository.getCommentEntitiesByIdPost(id);
    }

    @Override
    public CommentEntity addComment(CommentEntity comment) {
        return commentRepository.save(comment);
    }

    @Override
    public void deleteComment(Integer id) {
        commentRepository.deleteById(id);
    }
}
