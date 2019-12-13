package com.netcracker.ivanmerkush.fapi.service;

import com.netcracker.ivanmerkush.fapi.models.Like;

public interface LikeService {
    Like addLike(Like like);
    void deleteLike(Integer id);
    Integer countLikesForPost(Integer idPost);
    Like getLike(Integer idUser, Integer idPost);
}
