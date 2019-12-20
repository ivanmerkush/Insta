package com.netcracker.ivanmerkush.fapi.service.impl;

import com.netcracker.ivanmerkush.fapi.models.Hashtag;
import com.netcracker.ivanmerkush.fapi.models.PostHashtag;
import com.netcracker.ivanmerkush.fapi.service.HashtagService;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.Arrays;
import java.util.List;

@Service
public class HashtagServiceImpl implements HashtagService {
    @Value("http://localhost:8080/")
    private String backendServerUrl;

    @Override
    public List<Hashtag> getHashtagsBySearch(String searchWord) {
        RestTemplate restTemplate = new RestTemplate();
        Hashtag[] users =  restTemplate.getForObject(backendServerUrl + "/api/hashtags/search?request=" + searchWord,
                Hashtag[].class);
        return Arrays.asList(users);
    }

    @Override
    public Hashtag saveHashtag(Hashtag hashtag) {
        RestTemplate restTemplate = new RestTemplate();
        return restTemplate.postForEntity(backendServerUrl + "/api/hashtags/hashtag", hashtag, Hashtag.class).getBody();
    }

    @Override
    public void savePostAndHashtag(Integer idPost, Integer idHashtag) {
        PostHashtag postHashtag = new PostHashtag(idPost, idHashtag);
        RestTemplate restTemplate = new RestTemplate();
        restTemplate.postForEntity(backendServerUrl + "/api/hashtags/posthashtag", postHashtag, PostHashtag.class);
    }

    @Override
    public Hashtag getHashtagByText(String text) {
        RestTemplate restTemplate = new RestTemplate();
        return restTemplate.getForObject(backendServerUrl + "/api/hashtags/text/" + text, Hashtag.class);
    }

    @Override
    public Hashtag getHashtagById(Integer id) {
        RestTemplate restTemplate = new RestTemplate();
        return restTemplate.getForObject(backendServerUrl + "/api/hashtags/id/" + id, Hashtag.class);
    }
}
