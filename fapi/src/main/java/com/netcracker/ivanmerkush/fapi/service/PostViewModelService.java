package com.netcracker.ivanmerkush.fapi.service;

import com.netcracker.ivanmerkush.fapi.models.PageViewModel;
import com.netcracker.ivanmerkush.fapi.models.PostViewModel;

import java.util.List;

public interface PostViewModelService {
    PageViewModel getFeedPosts(Integer idCurrentUser, Integer pageNo, Integer pageSize);
    PageViewModel getHomePosts(Integer idUser, Integer pageNo, Integer pageSize);
    PageViewModel getHashtagPosts(Integer idHashtag, Integer pageNo, Integer pageSize);
    void savePost(PostViewModel postViewModel);
}
