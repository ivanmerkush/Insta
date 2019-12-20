package com.netcracker.ivanmerkush.backend.controller;

import com.netcracker.ivanmerkush.backend.entity.LikeEntity;
import com.netcracker.ivanmerkush.backend.service.LikeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/likes")
public class LikeController {
    @Autowired
    private LikeService likeService;


    @PostMapping()
    public LikeEntity saveLike(@RequestBody LikeEntity like) {
        return likeService.saveLike(like);
    }

    @DeleteMapping(value = "/{id}")
    public void deleteLike(@PathVariable Integer id) {
        likeService.deleteLike(id);
    }

    @GetMapping(value ="/count/{id}")
    public Integer countLikes(@PathVariable(name = "id") Integer idPost) {
        return likeService.countLikesForPost(idPost);
    }

    @GetMapping(value= "/user/{idUser}/post/{idPost}")
    public LikeEntity getLike(@PathVariable(name = "idUser") Integer idUser, @PathVariable(name = "idPost") Integer idPost) {
        return likeService.getLike(idUser, idPost);
    }
    @GetMapping(value="/all")
    public List<LikeEntity> getAll() {
        return likeService.getAll();
    }
}