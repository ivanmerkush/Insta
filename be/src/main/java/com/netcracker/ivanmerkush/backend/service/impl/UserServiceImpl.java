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
    public List<UserEntity> getUsersBySearch(String searchWord, Integer pageNo, Integer pagesize) {
        PageRequest pageable = PageRequest.of(pageNo,pagesize, Sort.by("nickname").ascending());
        Slice<UserEntity> result =  repository.getUserEntitiesByNicknameContaining(searchWord, pageable);
        if(result.hasContent()) {
            return result.getContent();
        } else {
            return new ArrayList<>();
        }
    }

    @Override
    public UserEntity getUserByNickname(String name) {
        return repository.getUserEntityByNickname(name);
    }

    @Override
    public void deleteUser(Integer id) { repository.deleteById(id);};
}
