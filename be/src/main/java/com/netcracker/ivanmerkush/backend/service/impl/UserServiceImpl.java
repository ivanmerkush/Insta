package com.netcracker.ivanmerkush.backend.service.impl;

import com.netcracker.ivanmerkush.backend.entity.UserEntity;
import com.netcracker.ivanmerkush.backend.repository.UserRepository;
import com.netcracker.ivanmerkush.backend.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

@Component
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository repository;

    @Override
    public UserEntity getUserById(Integer id) {
        return repository.getUserEntityByIdUser(id);
    }

    @Override
    public UserEntity addUser(UserEntity account) {
        return repository.save(account);
    }

    @Override
    public List<UserEntity> getUsersBySearch(String searchWord) {
        return repository.getUserEntitiesByNicknameContaining(searchWord);
    }

    @Override
    public UserEntity getUserByNickname(String name) {
        return repository.getUserEntityByNickname(name);
    }
}
