package com.netcracker.ivanmerkush.fapi.controller;

import com.netcracker.ivanmerkush.fapi.models.Hashtag;
import com.netcracker.ivanmerkush.fapi.service.HashtagService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/hashtags")
public class HashtagController {

    HashtagService hashtagService;

    @GetMapping("/search")
    public List<Hashtag> getHashtagsBySearch(@RequestParam(name="request") String searchWord) {
        return hashtagService.getHashtagsBySearch(searchWord);
    }
}
