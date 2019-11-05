package com.netcracker.edu.fapi.controller;

import com.netcracker.edu.fapi.models.User;
import org.springframework.http.ResponseEntity;
        import org.springframework.web.bind.annotation.PathVariable;
        import org.springframework.web.bind.annotation.RequestMapping;
        import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/user")
public class UserController {

    @RequestMapping(value = "/{id}")
    public ResponseEntity<User> getUser(@PathVariable String id) throws InterruptedException {
        Long userId = Long.valueOf(id);
        return ResponseEntity.ok();
    }

}
