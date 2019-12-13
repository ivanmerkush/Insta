package com.netcracker.ivanmerkush.backend.repository;

import com.netcracker.ivanmerkush.backend.entity.PostEntity;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import javax.websocket.server.PathParam;
import java.util.List;

@Repository
public interface PostRepository extends CrudRepository<PostEntity, Integer> {


    List<PostEntity> getAllFindByIdAuthor(Integer id);

    Integer countAllByIdAuthor(Integer id);

    @Query("select p from PostEntity p join SubEntity s on s.idHost = p.idAuthor where s.idSubcriber = :idUser  ORDER BY p.date desc")
    List<PostEntity> getPostEntitiesByIdAuthor(@PathParam("idUser") Integer idUser, Pageable pageable);

}
