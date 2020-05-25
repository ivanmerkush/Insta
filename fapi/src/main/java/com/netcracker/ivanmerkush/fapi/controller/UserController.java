package com.netcracker.ivanmerkush.fapi.controller;

import com.netcracker.ivanmerkush.fapi.models.Status;
import com.netcracker.ivanmerkush.fapi.models.User;
import com.netcracker.ivanmerkush.fapi.service.ComplaintService;
import com.netcracker.ivanmerkush.fapi.service.UserService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.util.List;

@RestController
@RequestMapping("/api/users")
public class UserController {

    private UserService userService;
    private ComplaintService complaintService;


    public UserController(UserService userService, ComplaintService complaintService) {
        this.userService = userService;
        this.complaintService = complaintService;
    }

    @GetMapping(value ="/search")
    public ResponseEntity<List<User>> getUsersBySearch(@RequestParam(name ="request") String searchWord) {
        return ResponseEntity.ok(userService.getUsersBySearch(searchWord));
    }

    @PostMapping()
    public ResponseEntity<User> saveUser(@RequestBody User user) {
        if (user != null) {
            return ResponseEntity.ok(userService.saveUser(user));
        }
        return null;
    }

    @PutMapping("/block")
    public ResponseEntity<User> blockUser(@RequestBody User user) {
        if (user != null) {
            user.setStatus(Status.BANNED);
            complaintService.deleteComplaintsByAccuser(user.getIdUser());
            return ResponseEntity.ok(userService.saveUser(user));
        }
        return null;
    }

    @PutMapping("/unblock")
    public ResponseEntity<User> unblockUser(@RequestBody User user) {
        if (user != null) {
            user.setStatus(Status.ACTIVE);
            return ResponseEntity.ok(userService.saveUser(user));
        }
        return null;
    }

    @DeleteMapping(value ="/{id}")
    public void deleteUser(@PathVariable String id) {
        Integer userId = Integer.valueOf(id);
        userService.deleteUser(userId);
    }

    @GetMapping(value = "/id/{id}")
    public ResponseEntity<User> getUserById(@PathVariable String id) {
        Integer userId = Integer.valueOf(id);
        return ResponseEntity.ok(userService.getUserById(userId));
    }

    @GetMapping(value = "/login/{name}")
    public User getUserByNickname(@PathVariable String name) {
        return userService.getUserByNickname(name);
    }

    @GetMapping(value = "/login")
    public User getUserByNicknameAndPassword(@RequestParam(name = "nickname") String nickname,
                                             @RequestParam(name ="password") String password) {
        return userService.getUserByNicknameAndPassword(nickname, password);
    }



    @PostMapping(value = "/upload")
    public void handleFileUpload(@RequestParam("file") MultipartFile file) {
        if (!file.isEmpty()) {
            try {
                String uploadsDir = "D:/Photo/";

                String orgName = file.getOriginalFilename();

                String filePath = uploadsDir + orgName;
                File dest = new File(filePath);
                file.transferTo(dest);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

}
