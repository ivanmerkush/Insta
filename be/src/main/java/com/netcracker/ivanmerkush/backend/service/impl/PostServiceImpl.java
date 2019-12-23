package com.netcracker.ivanmerkush.backend.service.impl;

import com.netcracker.ivanmerkush.backend.entity.PostEntity;
import com.netcracker.ivanmerkush.backend.model.PageModel;
import com.netcracker.ivanmerkush.backend.repository.PostRepository;
import com.netcracker.ivanmerkush.backend.service.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Component;

import javax.websocket.server.PathParam;
import java.util.Optional;

@Component
public class PostServiceImpl implements PostService {

    @Autowired
    private PostRepository repository;

    @Override
    public PageModel getPostsForUser(Integer id, Integer pageNo, Integer pageSize) {
        Pageable pageable = PageRequest.of(pageNo, pageSize, Sort.by(Sort.Direction.DESC, "date"));
        Page<PostEntity> posts = repository.getAllFindByIdAuthor(id, pageable);
        return new PageModel((int)posts.getTotalElements(), posts.getContent());
    }

    @Override
    public void deletePost(Integer id) {
        repository.deleteById(id);
    }

    @Override
    public Optional<PostEntity> getPostByIdPost(Integer idPost) {
        return repository.findById(idPost);
    }

    @Override
    public Integer countPostsOfAuthor(Integer id) {
        return repository.countAllByIdAuthor(id);
    }

    @Override
    public PostEntity savePost(PostEntity post) { return repository.save(post); }

    @Override
    public PageModel getPostsForFeed(@PathParam("idUser") Integer idUser, Integer pageNo, Integer pageSize) {
        Pageable pageable = PageRequest.of(pageNo, pageSize, Sort.by(Sort.Direction.DESC, "date"));
        Page<PostEntity> posts = repository.getPostEntitiesByIdAuthor(idUser, pageable);
        return new PageModel((int)posts.getTotalElements(), posts.getContent());
    }

    @Override
    public PageModel getPostsByHashtag(@PathParam("idHashtag") Integer idHashtag, Integer pageNo, Integer pageSize) {
        Pageable pageable = PageRequest.of(pageNo, pageSize, Sort.by(Sort.Direction.DESC, "date"));
        Page<PostEntity> posts = repository.getPostEntitiesByIdPost(idHashtag, pageable);
        return new PageModel((int)posts.getTotalElements(), posts.getContent());
    }


}
