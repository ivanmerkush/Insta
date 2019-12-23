package com.netcracker.ivanmerkush.backend.service.impl;

import com.netcracker.ivanmerkush.backend.entity.UserEntity;
import com.netcracker.ivanmerkush.backend.repository.UserRepository;
import com.netcracker.ivanmerkush.backend.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Slice;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.awt.print.Pageable;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository repository;

    @Override
    public UserEntity getUserById(Integer id) {
        return repository.getUserEntityByIdUser(id);
    }

    @Override
    public UserEntity saveUser(UserEntity account) {
        return repository.save(account);
    }

    @Override
    public List<UserEntity> getUsersBySearch(String searchWord) {
        List<UserEntity> result =  repository.getUserEntitiesByNicknameContainingOrderByNicknameAsc(searchWord);
        return result;
    }

    @Override
    public UserEntity getUserByNickname(String name) {
        return repository.getUserEntityByNickname(name);
    }

    @Override
    public UserEntity getUserByNicknameAndPassword(String nickname, String password) {
        return repository.getUserEntityByNicknameAndPassword(nickname,password);
    }

    @Override
    public void deleteUser(Integer id) { repository.deleteById(id);};
}
