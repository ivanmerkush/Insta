package com.netcracker.ivanmerkush.fapi.controller;

import com.netcracker.ivanmerkush.fapi.models.PageViewModel;
import com.netcracker.ivanmerkush.fapi.models.PostViewModel;
import com.netcracker.ivanmerkush.fapi.service.PostViewModelService;
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

    @GetMapping(value ="/feed")
    public ResponseEntity<PageViewModel> getFeedPosts(@RequestParam(name="id") Integer id,
                                                            @RequestParam(name ="offset",defaultValue = "0") Integer pageNo,
                                                            @RequestParam(name="limit",defaultValue = "4") Integer pageSize) {
        return ResponseEntity.ok(postViewModelService.getFeedPosts(id, pageNo,pageSize));
    }
    @GetMapping(value ="/home")
    public ResponseEntity<PageViewModel> getHomePosts(@RequestParam(name="id") Integer id,
                                                      @RequestParam(name ="offset",defaultValue = "0") Integer pageNo,
                                                      @RequestParam(name="limit",defaultValue = "4") Integer pageSize) {
        return ResponseEntity.ok(postViewModelService.getHomePosts(id, pageNo, pageSize));
    }

    @GetMapping(value="/hashtag")
    public ResponseEntity<PageViewModel> getHashtagPosts(@RequestParam(name="id") Integer id,
                                                         @RequestParam(name ="offset",defaultValue = "0") Integer pageNo,
                                                         @RequestParam(name="limit",defaultValue = "4") Integer pageSize) {
        return ResponseEntity.ok(postViewModelService.getHashtagPosts(id, pageNo, pageSize));
    }
    @PostMapping(value ="/upload")
    public void addPost(@RequestBody PostViewModel postViewModel) {
        postViewModelService.savePost(postViewModel);
    }

}
