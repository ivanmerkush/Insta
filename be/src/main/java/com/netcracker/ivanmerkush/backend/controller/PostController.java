package com.netcracker.ivanmerkush.backend.controller;

import com.netcracker.ivanmerkush.backend.entity.PostEntity;
import com.netcracker.ivanmerkush.backend.service.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/api/posts")
public class PostController {

    @Autowired
    private PostService postService;


    @GetMapping(value = "/{id}")
    public List<PostEntity> getPostsForUser(@PathVariable(name = "id") Integer id) {
        return postService.getPostsForUser(id);
    }

    @DeleteMapping(value = "/{id}")
    public void deletePost(@PathVariable Integer id) {
        postService.deletePost(id);
    }


    @PostMapping()
    public PostEntity savePost(@RequestBody PostEntity post) {
        return postService.savePost(post);
    }


    @GetMapping(value ="/count{id}")
    public Integer countPosts(@PathVariable(name = "id") Integer id) {
        return postService.countPostsOfAuthor(id);
    }

    @GetMapping(value="/feed")
    @ResponseBody
    public List<PostEntity> getPostsForFeed(@RequestParam Integer id,
                                           @RequestParam(name ="offset",defaultValue = "0") Integer pageNo,
                                           @RequestParam(name="limit",defaultValue = "3") Integer pageSize
                                           ) {
        return postService.getPostsForFeed(id, pageNo, pageSize);
    }
}
