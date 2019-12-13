package com.netcracker.ivanmerkush.fapi.service.impl;

import com.netcracker.ivanmerkush.fapi.models.Post;
import com.netcracker.ivanmerkush.fapi.service.PostService;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import javax.websocket.OnError;
import java.util.Arrays;
import java.util.List;

@Service
public class PostServiceImpl implements PostService {
    @Value("${backend.server.url}")
    private String backendServerUrl;

    @Override
    public List<Post> getPostsForHome(Integer id, Integer pageNo, Integer pageSize) {
        RestTemplate restTemplate = new RestTemplate();
        Post[] posts =  restTemplate.getForObject(backendServerUrl + "/api/posts/home?id" + id + "&offset=" + pageNo + "&limit=" + pageSize, Post[].class);
        return Arrays.asList(posts);
    }

    @Override
    public void deletePost(Integer id) {
        RestTemplate restTemplate = new RestTemplate();
        restTemplate.delete(backendServerUrl + "/api/posts/" + id);
    }
    @Override
    public Integer countPostsForAuthor(Integer id) {
        RestTemplate restTemplate = new RestTemplate();
        Integer result = restTemplate.getForObject(backendServerUrl + "/api/posts/count" + id, Integer.class);
        return result;
    }

    @Override
    public Post savePost(Post post) {
        RestTemplate restTemplate = new RestTemplate();
        return restTemplate.postForEntity(backendServerUrl + "/api/posts", post, Post.class).getBody();
    }

    @Override
    public List<Post> getPostsForFeed(Integer id, Integer pageNo, Integer pageSize) {
        RestTemplate restTemplate = new RestTemplate();
        Post[] posts = restTemplate.getForObject(backendServerUrl + "/api/posts/feed?id=" + id + "&offset=" + pageNo + "&limit=" + pageSize, Post[].class);
        return Arrays.asList(posts);
    }

}
