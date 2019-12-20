package com.netcracker.ivanmerkush.backend.service;

import com.netcracker.ivanmerkush.backend.entity.LikeEntity;

import java.util.List;

public interface LikeService {
    Integer countLikesForPost(Integer idPost);
    LikeEntity saveLike(LikeEntity like);
    void deleteLike(Integer id);
    LikeEntity getLike(Integer idUser, Integer idPost);
    List<LikeEntity> getAll();
}
