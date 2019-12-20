package com.netcracker.ivanmerkush.backend.controller;


import com.netcracker.ivanmerkush.backend.entity.CommentEntity;
import com.netcracker.ivanmerkush.backend.model.CommentViewModel;
import com.netcracker.ivanmerkush.backend.service.CommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/comments")
public class CommentController {

    @Autowired
    CommentService commentService;

    @GetMapping(value = "/{id}")
    public List<CommentViewModel> getCommentsForPost(@PathVariable(name = "id") Integer id) {
        return commentService.getCommentsForPost(id);
    }

    @PostMapping()
    public CommentEntity saveComment(@RequestBody CommentEntity comment) {
        return commentService.saveComment(comment);
    }

    @DeleteMapping(value="/{id}")
    public void deleteComment(@PathVariable(name="id") Integer id) {
        commentService.deleteComment(id);
    }
}

