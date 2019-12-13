package com.netcracker.ivanmerkush.backend.service;

import com.netcracker.ivanmerkush.backend.entity.PostEntity;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;

import java.util.List;

public interface PostService {
    List<PostEntity> getPostsForUser(Integer id);
    void deletePost(Integer id);
    Integer countPostsOfAuthor(Integer id);
    PostEntity savePost(PostEntity post);
    List<PostEntity> getPostsForFeed(Integer id, Integer pageNo, Integer pagesize);
}
