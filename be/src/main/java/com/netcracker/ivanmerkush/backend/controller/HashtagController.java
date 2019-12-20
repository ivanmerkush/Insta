package com.netcracker.ivanmerkush.backend.controller;

import com.netcracker.ivanmerkush.backend.entity.HashtagEntity;
import com.netcracker.ivanmerkush.backend.entity.PostHashtagEntity;
import com.netcracker.ivanmerkush.backend.service.HashtagService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/hashtags")
public class HashtagController {

    @Autowired
    private HashtagService hashtagService;

    @PostMapping(value="/hashtag")
    public HashtagEntity saveHashtag(@RequestBody HashtagEntity hashtag) {
        return hashtagService.saveHashtag(hashtag);
    }

    @GetMapping(value="/search")
    public List<HashtagEntity> getHashtagsBySearch(@RequestParam(name="request") String searchWord) {
        return hashtagService.getHashtagsBySearch(searchWord);
    }

    @GetMapping(value="/id/{id}")
    public HashtagEntity getHashtagsById(@PathVariable(name ="id") Integer id) {
        return hashtagService.getHashtagById(id);
    }

    @GetMapping(value="/text/{text}")
    public HashtagEntity getHashtagsByText(@PathVariable String text) {
        HashtagEntity hashtag =  hashtagService.getHashtagByText(text);
        return hashtag;
    }

    @PostMapping(value = "/posthashtag")
    public void savePostHashtag(@RequestBody PostHashtagEntity postHashtagEntity) {
        hashtagService.savePostHashtag(postHashtagEntity);
    }
}
