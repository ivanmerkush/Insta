package com.netcracker.ivanmerkush.fapi.controller;

import com.netcracker.ivanmerkush.fapi.models.PostViewModel;
import com.netcracker.ivanmerkush.fapi.service.PostViewModelService;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/page")
public class PostViewModelController {

    private PostViewModelService postViewModelService;

    public PostViewModelController(PostViewModelService postViewModelService) {
        this.postViewModelService = postViewModelService;
    }

    @GetMapping(value ="/feed/{id}")
    public ResponseEntity<List<PostViewModel>> getFeedPosts(@PathVariable String id,
                                                            @RequestParam(name ="offset",defaultValue = "0") Integer pageNo,
                                                            @RequestParam(name="limit",defaultValue = "5") Integer pageSize) {
        return ResponseEntity.ok(postViewModelService.getFeedPosts(Integer.valueOf(id), pageNo,pageSize));
    }
    @GetMapping(value ="/home/{id}")
    public ResponseEntity<List<PostViewModel>> getHomePosts(@PathVariable String id,
                                                            @RequestParam(name ="offset",defaultValue = "0") Integer pageNo,
                                                            @RequestParam(name="limit",defaultValue = "5") Integer pageSize) {
        return ResponseEntity.ok(postViewModelService.getHomePosts(Integer.valueOf(id), pageNo, pageSize));
    }

    @PostMapping(value ="/upload")
    public void addPost(@RequestBody PostViewModel postViewModel) {
        postViewModelService.addPost(postViewModel);
    }

}
