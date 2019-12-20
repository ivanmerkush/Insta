package com.netcracker.ivanmerkush.backend.service.impl;

import com.netcracker.ivanmerkush.backend.entity.LikeEntity;
import com.netcracker.ivanmerkush.backend.repository.LikeRepository;
import com.netcracker.ivanmerkush.backend.service.LikeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class LikeServiceImpl implements LikeService {

    @Autowired
    LikeRepository likeRepository;

    @Override
    public void deleteLike(Integer id) {
        likeRepository.deleteById(id);
    }

    @Override
    public LikeEntity saveLike(LikeEntity like) {
        return likeRepository.save(like);
    }

    @Override
    public LikeEntity getLike(Integer idUser, Integer idPost) {
        return likeRepository.getLikeEntityByIdUserAndIdPost(idUser, idPost);
    }

    @Override
    public List<LikeEntity> getAll() {
        return (List<LikeEntity>) likeRepository.findAll();
    }

    @Override
    public Integer countLikesForPost(Integer idPost) {
       return likeRepository.countLikeEntitiesByIdPost(idPost);
    }
}
