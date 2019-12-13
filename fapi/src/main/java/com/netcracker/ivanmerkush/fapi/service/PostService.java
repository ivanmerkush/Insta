package com.netcracker.ivanmerkush.fapi.service;

import com.netcracker.ivanmerkush.fapi.models.Post;

import java.util.List;

public interface PostService {
    List<Post> getPostsForHome(Integer id, Integer pageNo, Integer pageSize);
    void deletePost(Integer id);
    Integer countPostsForAuthor(Integer id);
    Post savePost(Post post);
    List<Post> getPostsForFeed(Integer id, Integer pageNo, Integer pageSize);
}
