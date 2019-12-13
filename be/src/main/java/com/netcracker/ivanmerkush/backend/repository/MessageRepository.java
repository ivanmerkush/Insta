package com.netcracker.ivanmerkush.backend.repository;

import com.netcracker.ivanmerkush.backend.entity.MessageEntity;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface MessageRepository extends CrudRepository<MessageEntity, Integer> {
    List<MessageEntity> getMessageEntitiesByIdDirect(Integer id);
}
