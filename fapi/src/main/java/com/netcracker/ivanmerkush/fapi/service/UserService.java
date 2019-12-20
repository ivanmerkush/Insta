package com.netcracker.ivanmerkush.fapi.service;

import com.netcracker.ivanmerkush.fapi.models.User;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface UserService {
    User getUserById(Integer id);

    List<User> getUsersBySearch(String searchWord);

    User saveUser(User user);

    User getUserByNickname(String name);

    void deleteUser(Integer id);
}
