package com.netcracker.ivanmerkush.fapi.service.impl;

import com.netcracker.ivanmerkush.fapi.models.Post;
import com.netcracker.ivanmerkush.fapi.service.PostService;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.Arrays;
import java.util.List;

@Service
public class PostServiceImpl implements PostService {
    @Value("${backend.server.url}")
    private String backendServerUrl;

    @Override
    public List<Post> getPostsForUser(Long id) {
        RestTemplate restTemplate = new RestTemplate();
        Post[] posts =  restTemplate.getForObject(backendServerUrl + "/api/posts/" + id, Post[].class);
        return Arrays.asList(posts);
    }

    @Override
    public void deletePost(Long id) {
        RestTemplate restTemplate = new RestTemplate();
        restTemplate.delete(backendServerUrl + "/api/posts/" + id);
    }
    @Override
    public Integer countPostsForAuthor(Long id) {
        RestTemplate restTemplate = new RestTemplate();
        Integer result = restTemplate.getForObject(backendServerUrl + "/api/posts/count" + id, Integer.class);
        return result;
    }
}
