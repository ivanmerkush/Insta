package com.netcracker.ivanmerkush.backend.controller;

import com.netcracker.ivanmerkush.backend.entity.UserEntity;
import com.netcracker.ivanmerkush.backend.service.impl.UserServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/users")
public class UserController {

    @Autowired
    private UserServiceImpl userService ;

    @GetMapping(value = "/id/{id}")
    public ResponseEntity<UserEntity> getUserById(@PathVariable(name = "id") Integer id) {
        UserEntity user = userService.getUserById(id);
        return ResponseEntity.ok(user);
    }

    @PostMapping()
    public UserEntity saveUser(@RequestBody UserEntity account) {
        return userService.saveUser(account);
    }

    @GetMapping(value = "/search")
    public List<UserEntity> getUsersBySearch(@RequestParam(name="request") String searchWord) {
        return userService.getUsersBySearch(searchWord);
    }

    @GetMapping(value = "/login/{name}")
    public UserEntity getUserByNickname(@PathVariable(name = "name") String name) {
        UserEntity user = userService.getUserByNickname(name);
        return user;
    }

    @DeleteMapping(value ="/{id}")
    public void deleteUser(@PathVariable(name="id") Integer id) {
        userService.deleteUser(id);
    }
}
