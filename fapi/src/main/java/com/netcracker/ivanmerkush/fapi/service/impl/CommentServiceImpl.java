package com.netcracker.ivanmerkush.fapi.service.impl;

import com.netcracker.ivanmerkush.fapi.models.Comment;
import com.netcracker.ivanmerkush.fapi.models.CommentViewModel;
import com.netcracker.ivanmerkush.fapi.service.CommentService;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.Arrays;
import java.util.List;

@Service
public class CommentServiceImpl implements CommentService {
    @Value("http://localhost:8080/")
    private String backendServerUrl;

    @Override
    public Comment saveComment(Comment comment) {
        RestTemplate restTemplate = new RestTemplate();
        return restTemplate.postForEntity(backendServerUrl + "/api/comments", comment, Comment.class).getBody();
    }

    @Override
    public void deleteComment(Integer id) {
        RestTemplate restTemplate = new RestTemplate();
        restTemplate.delete(backendServerUrl + "/api/comments/" + id);
    }

    @Override
    public List<CommentViewModel> getCommentsByIdPost(Integer idPost) {
        RestTemplate restTemplate = new RestTemplate();
        CommentViewModel[] comments =  restTemplate.getForObject(backendServerUrl + "/api/comments/" + idPost,
                CommentViewModel[].class);
        return Arrays.asList(comments);
    }
}
