package com.netcracker.ivanmerkush.backend.service;

import com.netcracker.ivanmerkush.backend.entity.CommentEntity;
import com.netcracker.ivanmerkush.backend.model.CommentViewModel;

import java.util.List;

public interface CommentService {
    List<CommentViewModel> getCommentsForPost(Integer idPost);
    CommentEntity saveComment(CommentEntity comment);
    void deleteComment(Integer id);

}
