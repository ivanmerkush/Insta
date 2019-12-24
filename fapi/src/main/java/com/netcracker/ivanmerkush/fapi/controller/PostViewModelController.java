package com.netcracker.ivanmerkush.fapi.controller;

import com.netcracker.ivanmerkush.fapi.models.PageViewModel;
import com.netcracker.ivanmerkush.fapi.models.Post;
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

    @GetMapping(value = "/user/{idUser}/post/{idPost}")
    public ResponseEntity<PostViewModel> getPostByIdPost(@PathVariable(name="idUser") Integer idUser, @PathVariable(name="idPost") Integer idPost) {
        PostViewModel postViewModel = postViewModelService.getPostByIdPost(idUser, idPost);
        if(postViewModel != null) {
            return ResponseEntity.ok(postViewModel);
        }
         return null;
    }
    @PostMapping(value ="/upload")
    public void addPost(@RequestBody PostViewModel postViewModel) {
        postViewModelService.savePost(postViewModel);
    }

    @GetMapping(value="/all")
    public ResponseEntity<List<PostViewModel>> getMostLikedPosts() {
        List<PostViewModel> postViewModels = postViewModelService.getMostLikedPosts();
        return ResponseEntity.ok(postViewModels);
    }
}
