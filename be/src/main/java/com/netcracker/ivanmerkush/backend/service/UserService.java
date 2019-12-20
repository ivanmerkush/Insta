package com.netcracker.ivanmerkush.backend.service;

import com.netcracker.ivanmerkush.backend.entity.UserEntity;
import org.apache.catalina.User;
import org.springframework.data.domain.Page;

import java.util.List;
import java.util.Optional;

public interface UserService {
    UserEntity getUserById(Integer id);
    UserEntity saveUser(UserEntity account);
    List<UserEntity> getUsersBySearch(String searchWord);
    UserEntity getUserByNickname(String name);
    void deleteUser(Integer id);
}
