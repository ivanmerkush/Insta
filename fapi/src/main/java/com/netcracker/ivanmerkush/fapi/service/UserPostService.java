package com.netcracker.ivanmerkush.fapi.service;

import com.netcracker.ivanmerkush.fapi.models.UserPost;

import java.util.List;

public interface UserPostService {
    List<UserPost> getUserPostsForFeed(Long id);
}
