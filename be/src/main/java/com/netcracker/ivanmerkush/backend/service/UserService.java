package com.netcracker.ivanmerkush.backend.service;

import com.netcracker.ivanmerkush.backend.entity.UserEntity;
import org.apache.catalina.User;

import java.util.List;
import java.util.Optional;

public interface UserService {
    UserEntity getUserById(Integer id);
    UserEntity addUser(UserEntity account);
    List<UserEntity> getUsersBySearch(String searchWord);
    UserEntity getUserByNickname(String name);
}
