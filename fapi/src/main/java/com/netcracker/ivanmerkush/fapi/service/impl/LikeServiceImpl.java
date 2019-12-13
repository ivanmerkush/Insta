package com.netcracker.ivanmerkush.fapi.service.impl;

import com.netcracker.ivanmerkush.fapi.models.Like;
import com.netcracker.ivanmerkush.fapi.service.LikeService;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;


@Service
public class LikeServiceImpl implements LikeService {
    @Value("http:/localhost:8080/")
    private String backendServerUrl;

    @Override
    public Like addLike(Like like) {
        RestTemplate restTemplate = new RestTemplate();
        return restTemplate.postForEntity(backendServerUrl + "/api/likes", like, Like.class).getBody();
    }

    @Override
    public void deleteLike(Integer id) {
        RestTemplate restTemplate = new RestTemplate();
        restTemplate.delete(backendServerUrl + "/api/likes/" + id);
    }
    @Override
    public Integer countLikesForPost(Integer id) {
        RestTemplate restTemplate = new RestTemplate();
        Integer result = restTemplate.getForObject(backendServerUrl + "/api/likes/count/" + id, Integer.class);
        return result;
    }


    @Override
    public Like getLike(Integer idUser, Integer idPost) {
        RestTemplate restTemplate = new RestTemplate();
        Like like = restTemplate.getForObject(backendServerUrl + "api/likes/user/" + idUser + "/post/" + idPost,
                Like.class);
        return like;
    }
}
