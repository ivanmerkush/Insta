package com.netcracker.ivanmerkush.fapi.controller;


import com.netcracker.ivanmerkush.fapi.models.PageModel;
import com.netcracker.ivanmerkush.fapi.models.Post;
import com.netcracker.ivanmerkush.fapi.service.PostService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/posts")
public class PostController {

    private PostService postService;


    public PostController(PostService postService) {
        this.postService = postService;
    }

    @DeleteMapping(value = "/{id}")
    public void deletePost(@PathVariable String id) {
        postService.deletePost(Integer.valueOf(id));
    }

    @GetMapping(value ="/count/{id}")
    public ResponseEntity<Integer> countPosts(@PathVariable String id) {
        return ResponseEntity.ok(postService.countPostsForAuthor(Integer.valueOf(id)));
    }

    @GetMapping(value="/feed")
    public ResponseEntity<PageModel> getPostsForFeed(@RequestParam(name="id") Integer id,
                                                     @RequestParam(name ="offset",defaultValue = "0") Integer pageNo,
                                                     @RequestParam(name="limit",defaultValue = "4") Integer pageSize) {
        return ResponseEntity.ok(postService.getPostsForFeed(id, pageNo, pageSize));
    }
}
