package com.netcracker.ivanmerkush.fapi.service.impl;

import com.netcracker.ivanmerkush.fapi.models.Post;
import com.netcracker.ivanmerkush.fapi.models.Sub;
import com.netcracker.ivanmerkush.fapi.models.User;
import com.netcracker.ivanmerkush.fapi.models.UserPost;
import com.netcracker.ivanmerkush.fapi.service.PostService;
import com.netcracker.ivanmerkush.fapi.service.SubService;
import com.netcracker.ivanmerkush.fapi.service.UserPostService;
import com.netcracker.ivanmerkush.fapi.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class UserPostServiceImpl implements UserPostService {

    private UserService userService;

    private PostService postService;

    private SubService subService;

    public UserPostServiceImpl(UserService userService, PostService postService, SubService subService) {
        this.userService = userService;
        this.postService = postService;
        this.subService = subService;
    }

    public List<UserPost> getUserPostsForFeed(Long id) {
        List<Sub> subs = subService.getSubscriptions(id);
        List<User> subscriptions = new ArrayList<>();
        subs.forEach(sub -> {
            subscriptions.add(userService.getUserById((long) sub.getIdHost()));
        });
        List<UserPost> userPosts = new ArrayList<>();
        List<Post> posts = new ArrayList<>();
        for (User subscription : subscriptions) {
            posts.addAll(postService.getPostsForUser((long) subscription.getIdUser()));
            posts.forEach(post -> {
                userPosts.add(new UserPost(subscription.getIdUser(), subscription.getNickname(), post));
            });
        }

        return userPosts;
    }
}
