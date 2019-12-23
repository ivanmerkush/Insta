package com.netcracker.ivanmerkush.backend.repository;

import com.netcracker.ivanmerkush.backend.entity.CommentEntity;
import com.netcracker.ivanmerkush.backend.model.CommentViewModel;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CommentRepository extends CrudRepository<CommentEntity, Integer> {
    List<CommentEntity> getCommentEntitiesByIdPost(Integer id, Sort sort);
}
