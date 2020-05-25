package com.netcracker.ivanmerkush.fapi.service.impl;

import com.netcracker.ivanmerkush.fapi.models.User;
import com.netcracker.ivanmerkush.fapi.models.UserViewModel;
import com.netcracker.ivanmerkush.fapi.service.PostService;
import com.netcracker.ivanmerkush.fapi.service.SubService;
import com.netcracker.ivanmerkush.fapi.service.UserService;
import com.netcracker.ivanmerkush.fapi.service.UserViewModelService;
import org.springframework.stereotype.Service;

@Service
public class UserViewModelServiceImpl implements UserViewModelService {
    private UserService userService;
    private PostService postService;
    private SubService subService;

    public UserViewModelServiceImpl(UserService userService, PostService postService, SubService subService) {
        this.userService = userService;
        this.postService = postService;
        this.subService = subService;
    }

    @Override
    public UserViewModel getUserViewModel(Integer id) {
        User user = userService.getUserById(id);
        if(user == null) {
            return null;
        }
        int numberOfPosts = postService.countPostsForAuthor(id);
        int subscribers = subService.countSubscribers(id);
        int subscriptions = subService.countSubscriptions(id);
        return new UserViewModel(user.getIdUser(), user.getNickname(), user.getName(), user.getEmail(), user.getInfo(), user.getStatus(), user.getRole()
                , user.getProfilePhoto(), numberOfPosts, subscribers, subscriptions);
    }
}

