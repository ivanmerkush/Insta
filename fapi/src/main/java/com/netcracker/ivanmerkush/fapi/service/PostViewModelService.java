package com.netcracker.ivanmerkush.fapi.service;

import com.netcracker.ivanmerkush.fapi.models.PostViewModel;

import java.util.List;

public interface PostViewModelService {
    List<PostViewModel> getFeedPosts(Integer id, Integer pageNo, Integer pageSize);
    List<PostViewModel> getHomePosts(Integer id, Integer pageNo,Integer pageSize);
    void addPost(PostViewModel postViewModel);
}
