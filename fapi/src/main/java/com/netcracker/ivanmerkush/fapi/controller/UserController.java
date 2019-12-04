package com.netcracker.ivanmerkush.fapi.controller;

import com.netcracker.ivanmerkush.fapi.models.User;
import com.netcracker.ivanmerkush.fapi.service.UserService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/users")
public class UserController {

    private UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @RequestMapping(value ="/{searchWord}")
    public ResponseEntity<List<User>> getUsersBySearch(@PathVariable String searchWord) {
        return ResponseEntity.ok(userService.getUsersBySearch(searchWord));
    }

    @RequestMapping(method = RequestMethod.POST)
    public ResponseEntity<User> saveUser(@RequestBody User user/*todo server validation*/) {
        if (user != null) {
            return ResponseEntity.ok(userService.saveUser(user));
        }
        return null;
    }

    @RequestMapping(value = "/id{id}")
    public ResponseEntity<User> getUserById(@PathVariable String id) {
        Long userId = Long.valueOf(id);
        return ResponseEntity.ok(userService.getUserById(userId));
    }

    @RequestMapping(value = "/login{name}")
    public ResponseEntity<User> getUserByNickname(@PathVariable String name) {
        return ResponseEntity.ok(userService.getUserByNickname(name));
    }

}
