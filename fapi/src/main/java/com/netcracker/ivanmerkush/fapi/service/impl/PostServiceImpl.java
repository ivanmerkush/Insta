package com.netcracker.ivanmerkush.fapi.service.impl;

import com.netcracker.ivanmerkush.fapi.models.PageModel;
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
    public void deletePost(Integer id) {
        RestTemplate restTemplate = new RestTemplate();
        restTemplate.delete(backendServerUrl + "/api/posts/" + id);
    }
    @Override
    public Integer countPostsForAuthor(Integer id) {
        RestTemplate restTemplate = new RestTemplate();
        Integer result = restTemplate.getForObject(backendServerUrl + "/api/posts/count/" + id, Integer.class);
        return result;
    }

    @Override
    public Post savePost(Post post) {
        RestTemplate restTemplate = new RestTemplate();
        return restTemplate.postForEntity(backendServerUrl + "/api/posts", post, Post.class).getBody();
    }

    @Override
    public PageModel getPostsForHome(Integer id, Integer pageNo, Integer pageSize) {
        RestTemplate restTemplate = new RestTemplate();
        PageModel pageModel =  restTemplate.getForObject(backendServerUrl + "/api/posts/home?id=" + id + "&offset=" + pageNo + "&limit=" + pageSize,
                PageModel.class);
        return pageModel;
    }

    @Override
    public PageModel getPostsForFeed(Integer id, Integer pageNo, Integer pageSize) {
        RestTemplate restTemplate = new RestTemplate();
        PageModel pageModel= restTemplate.getForObject(backendServerUrl + "/api/posts/feed?id=" +id + "&offset=" + pageNo + "&limit=" + pageSize,
                PageModel.class);
        return pageModel;
    }

    @Override
    public PageModel getPostsForHashtag(Integer id, Integer pageNo, Integer pageSize) {
        RestTemplate restTemplate = new RestTemplate();
        PageModel pageModel= restTemplate.getForObject(backendServerUrl + "/api/posts/hashtag?id=" +id + "&offset=" + pageNo + "&limit=" + pageSize,
                PageModel.class);
        return pageModel;
    }

    @Override
    public Post getPostByIdPost(Integer idPost) {
        RestTemplate restTemplate = new RestTemplate();
        Post post = restTemplate.getForObject(backendServerUrl +"/api/posts/id/" + idPost, Post.class);
        return post;
    }

}
