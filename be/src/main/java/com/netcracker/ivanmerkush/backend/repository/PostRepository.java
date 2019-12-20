package com.netcracker.ivanmerkush.backend.repository;

import com.netcracker.ivanmerkush.backend.entity.PostEntity;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import javax.websocket.server.PathParam;

@Repository
public interface PostRepository extends CrudRepository<PostEntity, Integer> {


    Page<PostEntity> getAllFindByIdAuthor(Integer id, Pageable pageable);

    Integer countAllByIdAuthor(Integer id);

    @Query("select p from PostEntity p join SubEntity s on s.idHost = p.idAuthor where s.idSubcriber = :idUser")
    Page<PostEntity> getPostEntitiesByIdAuthor(@PathParam("idUser") Integer idUser, Pageable pageable);

    @Query("select p from PostEntity p join PostHashtagEntity ph on ph.idPost = p.idPost where ph.idHashtag = :idHashtag")
    Page<PostEntity> getPostEntitiesByIdPost(@PathParam("idHashtag") Integer idHashtag, Pageable pageable);
}
