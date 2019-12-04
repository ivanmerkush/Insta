package com.netcracker.ivanmerkush.backend.repository;

import com.netcracker.ivanmerkush.backend.entity.UserEntity;
import org.apache.catalina.User;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserRepository extends CrudRepository<UserEntity, Integer> {
    UserEntity getUserEntityByIdUser(Integer id);
    List<UserEntity> getUserEntitiesByNicknameContaining(String searchWord);
    UserEntity getUserEntityByNickname(String name);
}
