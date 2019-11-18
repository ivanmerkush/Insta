package com.netcracker.ivanmerkush.fapi.controller;


import com.netcracker.ivanmerkush.fapi.models.Post;
import com.netcracker.ivanmerkush.fapi.service.PostService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/posts")
public class PostController {

    private PostService postService;


    public PostController(PostService postService) {
        this.postService = postService;
    }

    @RequestMapping(value = "/{id}")
    public ResponseEntity<List<Post>> getPosts(@PathVariable String id) {
        Long idUser = Long.valueOf(id);
        return ResponseEntity.ok(postService.getPostsForUser(idUser));
    }
}
