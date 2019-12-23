package com.netcracker.ivanmerkush.backend.service;

import com.netcracker.ivanmerkush.backend.entity.PostEntity;
import com.netcracker.ivanmerkush.backend.model.PageModel;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;

import java.util.List;
import java.util.Optional;

public interface PostService {
    PageModel getPostsForUser(Integer id, Integer pageNo, Integer pagesize);
    void deletePost(Integer id);
    Optional<PostEntity> getPostByIdPost(Integer idPost);
    Integer countPostsOfAuthor(Integer id);
    PostEntity savePost(PostEntity post);
    PageModel getPostsForFeed(Integer id, Integer pageNo, Integer pagesize);
    PageModel getPostsByHashtag(Integer idHashtag, Integer pageNo, Integer pagesize);
}
