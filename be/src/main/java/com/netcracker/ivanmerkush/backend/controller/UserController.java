package com.netcracker.ivanmerkush.backend.controller;

import com.netcracker.ivanmerkush.backend.entity.UserEntity;
import com.netcracker.ivanmerkush.backend.service.UserService;
import com.netcracker.ivanmerkush.backend.service.impl.UserServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/users")
public class UserController {

    @Autowired
    private UserServiceImpl userService ;

    @RequestMapping(value = "/id{id}", method = RequestMethod.GET)
    public ResponseEntity<UserEntity> getUserById(@PathVariable(name = "id") Integer id) {
        UserEntity user = userService.getUserById(id);
        return ResponseEntity.ok(user);
    }

    @RequestMapping(method = RequestMethod.POST)
    public UserEntity addUser(@RequestBody UserEntity account) {
        return userService.addUser(account);
    }

    @RequestMapping(value = "/{searchWord}", method = RequestMethod.GET)
    public List<UserEntity> getUsersBySearch(@PathVariable String searchWord) {
        return userService.getUsersBySearch(searchWord);
    }

    @RequestMapping(value = "/login{name}", method = RequestMethod.GET)
    public ResponseEntity<UserEntity> getUserByNickname(@PathVariable(name = "name") String name) {
        UserEntity user = userService.getUserByNickname(name);
        return ResponseEntity.ok(user);
    }
}
