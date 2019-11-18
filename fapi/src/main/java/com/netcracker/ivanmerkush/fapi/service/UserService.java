package com.netcracker.ivanmerkush.fapi.service;

import com.netcracker.ivanmerkush.fapi.models.User;
import org.springframework.http.ResponseEntity;

public interface UserService {
    User getUserById(Long id);
}
