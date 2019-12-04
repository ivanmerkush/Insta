package com.netcracker.ivanmerkush.backend.service;

import com.netcracker.ivanmerkush.backend.entity.PostEntity;

import java.util.List;

public interface PostService {
    List<PostEntity> getPostsForUser(Integer id);
    void deletePost(Integer id);
    Integer countPostsOfAuthor(Integer id);
}
