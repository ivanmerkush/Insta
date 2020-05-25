package com.netcracker.ivanmerkush.backend.repository;

import com.netcracker.ivanmerkush.backend.entity.UserEntity;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserRepository extends CrudRepository<UserEntity, Integer> {
    UserEntity getUserEntityByIdUser(Integer id);
    List<UserEntity> getUserEntitiesByNicknameContainingOrderByNicknameAsc(String searchWord);
    UserEntity getUserEntityByNickname(String name);
    UserEntity getUserEntityByNicknameAndPassword(String nickname, String password);
}
