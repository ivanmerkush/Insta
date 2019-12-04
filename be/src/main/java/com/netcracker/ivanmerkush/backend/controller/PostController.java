package com.netcracker.ivanmerkush.backend.controller;

import com.netcracker.ivanmerkush.backend.entity.PostEntity;
import com.netcracker.ivanmerkush.backend.service.PostService;
import com.netcracker.ivanmerkush.backend.service.impl.PostServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;


@RestController
@RequestMapping("/api/posts")
public class PostController {

    @Autowired
    private PostServiceImpl postService;


    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public List<PostEntity> getPostsForUser(@PathVariable(name = "id") Integer id) {
        return postService.getPostsForUser(id);
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    public void deletePost(@PathVariable Integer id) {
        postService.deletePost(id);
    }


    @RequestMapping(value ="/count{id}", method = RequestMethod.GET)
    public Integer countPosts(@PathVariable(name = "id") Integer id) {
        return postService.countPostsOfAuthor(id);
    }
}
