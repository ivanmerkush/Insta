package com.netcracker.ivanmerkush.fapi.service;

import com.netcracker.ivanmerkush.fapi.models.PageModel;
import com.netcracker.ivanmerkush.fapi.models.Post;

import java.util.List;

public interface PostService {
    PageModel getPostsForHome(Integer id, Integer pageNo, Integer pageSize);
    void deletePost(Integer id);
    Integer countPostsForAuthor(Integer id);
    Post savePost(Post post);
    PageModel getPostsForFeed(Integer id, Integer pageNo, Integer pageSize);
    PageModel getPostsForHashtag(Integer id, Integer pageNo, Integer pageSize);
}
