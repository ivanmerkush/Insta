package com.netcracker.ivanmerkush.backend.repository;

import com.netcracker.ivanmerkush.backend.entity.LikeEntity;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LikeRepository extends CrudRepository<LikeEntity, Integer> {
    LikeEntity getLikeEntityByIdUserAndIdPost(Integer idUser, Integer idPost);
    Integer countLikeEntitiesByIdPost(Integer idPost);

}
