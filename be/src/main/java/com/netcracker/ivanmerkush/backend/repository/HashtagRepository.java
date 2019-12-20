package com.netcracker.ivanmerkush.backend.repository;

import com.netcracker.ivanmerkush.backend.entity.HashtagEntity;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface HashtagRepository extends CrudRepository<HashtagEntity, Integer> {
    List<HashtagEntity> getHashtagEntitiesByTextContaining(String text);
    HashtagEntity getHashtagEntityByIdHashtag(Integer id);
    HashtagEntity getHashtagEntityByText(String text);
}
