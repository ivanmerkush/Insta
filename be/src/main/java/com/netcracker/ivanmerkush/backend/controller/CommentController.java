package com.netcracker.ivanmerkush.backend.controller;


import com.netcracker.ivanmerkush.backend.entity.CommentEntity;
import com.netcracker.ivanmerkush.backend.service.impl.CommentServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/comments")
public class CommentController {

    @Autowired
    CommentServiceImpl commentService;

    @GetMapping(value = "/{id}")
    public List<CommentEntity> getCommentsForPost(@PathVariable(name = "id") Integer id) {
        return commentService.getCommentsForPost(id);
    }

    @PostMapping()
    public CommentEntity addComment(CommentEntity comment) {
        return commentService.addComment(comment);
    }

    @DeleteMapping()
    public void deleteComment(Integer id) {
        commentService.deleteComment(id);
    }
}

