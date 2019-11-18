package com.netcracker.ivanmerkush.backend.service;

import com.netcracker.ivanmerkush.backend.entity.UserEntity;

import java.util.Optional;

public interface UserService {
    Optional<UserEntity> getUserById(Integer id);
}
