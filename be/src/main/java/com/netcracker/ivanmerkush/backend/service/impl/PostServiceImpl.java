package com.netcracker.ivanmerkush.backend.service.impl;

import com.netcracker.ivanmerkush.backend.entity.PostEntity;
import com.netcracker.ivanmerkush.backend.repository.PostRepository;
import com.netcracker.ivanmerkush.backend.service.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Component;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.websocket.server.PathParam;
import java.util.List;

@Component
public class PostServiceImpl implements PostService {

    @Autowired
    private PostRepository repository;

    @Override
    public List<PostEntity> getPostsForUser(Integer id) {
        return repository.getAllFindByIdAuthor(id);
    }

    @Override
    public void deletePost(Integer id) {
        repository.deleteById(id);
    }

    @Override
    public Integer countPostsOfAuthor(Integer id) {
        return repository.countAllByIdAuthor(id);
    }

    @Override
    public PostEntity savePost(PostEntity post) { return repository.save(post); }


    public List<PostEntity> getPostsForFeed(@PathParam("idUser") Integer idUser, Integer pageNo, Integer pageSize) {
        Pageable pageable = PageRequest.of(pageNo, pageSize);
        List<PostEntity> posts = repository.getPostEntitiesByIdAuthor(idUser, pageable);
        return posts;
    }


}
