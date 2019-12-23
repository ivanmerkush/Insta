package com.netcracker.ivanmerkush.fapi.service.impl;

import com.netcracker.ivanmerkush.fapi.models.User;
import com.netcracker.ivanmerkush.fapi.service.UserService;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.Arrays;
import java.util.List;

@Service
public class UserServiceImpl implements UserService {
    @Value("http://localhost:8080/")
    private String backendServerUrl;

    @Override
    public User getUserById(Integer id) {
        RestTemplate restTemplate = new RestTemplate();
        return restTemplate.getForObject(backendServerUrl + "/api/users/id/" + id, User.class);
    }

    @Override
    public List<User> getUsersBySearch(String searchWord) {
        RestTemplate restTemplate = new RestTemplate();
        User[] users =  restTemplate.getForObject(backendServerUrl + "/api/users/search?request=" + searchWord,
                User[].class);
        return Arrays.asList(users);
    }

    @Override
    public User saveUser(User account) {
        RestTemplate restTemplate = new RestTemplate();
        return restTemplate.postForEntity(backendServerUrl + "/api/users", account, User.class).getBody();
    }

    @Override
    public User getUserByNickname(String name) {
        RestTemplate restTemplate = new RestTemplate();
        return restTemplate.getForObject(backendServerUrl + "/api/users/login/" + name, User.class);
    }

    @Override
    public User getUserByNicknameAndPassword(String nickname, String password) {
        RestTemplate restTemplate = new RestTemplate();
        return restTemplate.getForObject(backendServerUrl + "/api/users/login?nickname=" + nickname + "&password=" + password, User.class);
    }

    @Override
    public void deleteUser(Integer id) {
        RestTemplate restTemplate = new RestTemplate();
        restTemplate.delete(backendServerUrl + "/api/users/" + id);
    }
}
