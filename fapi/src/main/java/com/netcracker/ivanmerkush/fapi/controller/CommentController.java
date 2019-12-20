package com.netcracker.ivanmerkush.fapi.controller;

import com.netcracker.ivanmerkush.fapi.models.Comment;
import com.netcracker.ivanmerkush.fapi.models.CommentViewModel;
import com.netcracker.ivanmerkush.fapi.service.CommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/comments")
public class CommentController {

    CommentService commentService;

    public CommentController(CommentService commentService) {
        this.commentService = commentService;
    }

    @GetMapping(value="/{id}")
    public List<CommentViewModel> getComments(@PathVariable(name="id") Integer idPost) {
        return commentService.getCommentsByIdPost(idPost);
    }

    @PostMapping()
    public Comment saveComment(@RequestBody Comment comment) {
        if (comment != null) {
            return commentService.saveComment(comment);
        }
        return null;
    }

    @DeleteMapping(value="/{id}")
    public void deleteComment(@PathVariable(name="id") Integer id) {
        commentService.deleteComment(id);
    }
}
