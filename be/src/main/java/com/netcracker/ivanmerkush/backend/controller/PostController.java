package com.netcracker.ivanmerkush.backend.controller;

import com.netcracker.ivanmerkush.backend.entity.PostEntity;
import com.netcracker.ivanmerkush.backend.model.PageModel;
import com.netcracker.ivanmerkush.backend.service.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;


@RestController
@RequestMapping("/api/posts")
public class PostController {

    @Autowired
    private PostService postService;

    @GetMapping(value="/id/{id}")
    public Optional<PostEntity> getPostByIdPost(@PathVariable(name="id") Integer id) {
        return postService.getPostByIdPost(id);
    }

    @GetMapping(value = "/home")
    public PageModel getPostsForUser(@RequestParam(name = "id") Integer id,
                                     @RequestParam(name ="offset",defaultValue = "0") Integer pageNo,
                                     @RequestParam(name="limit",defaultValue = "4") Integer pageSize) {
        return postService.getPostsForUser(id, pageNo, pageSize);
    }

    @DeleteMapping(value = "/{id}")
    public void deletePost(@PathVariable Integer id) {
        postService.deletePost(id);
    }


    @PostMapping()
    public PostEntity savePost(@RequestBody PostEntity post) {
        return postService.savePost(post);
    }


    @GetMapping(value ="/count/{id}")
    public Integer countPosts(@PathVariable(name = "id") Integer id) {
        return postService.countPostsOfAuthor(id);
    }

    @GetMapping(value="/feed")
    public PageModel getPostsForFeed(@RequestParam(name="id") Integer id,
                                     @RequestParam(name ="offset",defaultValue = "0") Integer pageNo,
                                     @RequestParam(name="limit",defaultValue = "4") Integer pageSize
                                           ) {
        return postService.getPostsForFeed(id, pageNo, pageSize);
    }

    @GetMapping(value="/hashtag")
    public PageModel getPostsByHashtag(@RequestParam(name="id") Integer id,
                                        @RequestParam(name ="offset",defaultValue = "0") Integer pageNo,
                                        @RequestParam(name="limit",defaultValue = "4") Integer pageSize
    ) {
        return postService.getPostsByHashtag(id, pageNo, pageSize);
    }

    @GetMapping(value="/all")
    public Iterable<PostEntity> getAllPosts() {
        return postService.getAllPosts();
    }
}
