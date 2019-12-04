package com.netcracker.ivanmerkush.fapi.service;

import com.netcracker.ivanmerkush.fapi.models.Post;

import java.util.List;

public interface PostService {
    List<Post> getPostsForUser(Long id);
    void deletePost(Long id);
    Integer countPostsForAuthor(Long id);
}
