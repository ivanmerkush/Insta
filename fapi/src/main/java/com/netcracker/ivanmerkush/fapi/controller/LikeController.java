package com.netcracker.ivanmerkush.fapi.controller;

import com.netcracker.ivanmerkush.fapi.models.Like;
import com.netcracker.ivanmerkush.fapi.service.LikeService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/likes")
public class LikeController {
    private LikeService likeService;

    public LikeController(LikeService likeService) {
        this.likeService = likeService;
    }

    @PostMapping()
    public ResponseEntity<Like> addLike(@RequestBody Like like) {
        if (like != null) {
            return ResponseEntity.ok(likeService.addLike(like));
        }
        return null;
    }

    @DeleteMapping(value ="/{id}")
    public void deleteLike(@PathVariable String id) {
        likeService.deleteLike(Integer.valueOf(id));
    }

    @GetMapping(value="/count/{idPost}")
    public ResponseEntity<Integer> countLikes(@PathVariable String idPost) {
        return ResponseEntity.ok(likeService.countLikesForPost(Integer.valueOf(idPost)));
    }

    @GetMapping(value="/user/{idUser}/post/{idPost}")
    public ResponseEntity<Like> getLike(@PathVariable String idUser, @PathVariable String idPost) {
        return ResponseEntity.ok(likeService.getLike(Integer.valueOf(idUser), Integer.valueOf(idPost)));
    }
}
