package com.netcracker.ivanmerkush.fapi.service;

import com.netcracker.ivanmerkush.fapi.models.Comment;
import com.netcracker.ivanmerkush.fapi.models.CommentViewModel;

import java.util.List;

public interface CommentService {
    Comment saveComment(Comment comment);
    void deleteComment(Integer id);
    List<CommentViewModel> getCommentsByIdPost(Integer idPost);
}
