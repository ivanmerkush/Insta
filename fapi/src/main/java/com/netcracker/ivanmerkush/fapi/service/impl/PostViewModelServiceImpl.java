package com.netcracker.ivanmerkush.fapi.service.impl;

import com.netcracker.ivanmerkush.fapi.models.*;
import com.netcracker.ivanmerkush.fapi.service.*;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class PostViewModelServiceImpl implements PostViewModelService {


    private UserService userService;
    private PostService postService;
    private SubService subService;
    private PhotoService photoService;
    private LikeService likeService;

    public PostViewModelServiceImpl(UserService userService, PostService postService, SubService subService,
                                    PhotoService photoService, LikeService likeService) {
        this.userService = userService;
        this.postService = postService;
        this.subService = subService;
        this.photoService = photoService;
        this.likeService = likeService;
    }

    @Override
    public List<PostViewModel> getFeedPosts(Integer id, Integer pageNo, Integer pageSize) {
        List<PostViewModel> postViewModels = new ArrayList<>();
        List<Post> posts = new ArrayList<>();
        posts.addAll(postService.getPostsForFeed(id, pageNo, pageSize));
        posts.forEach(post -> {
            int idPost = post.getIdPost();
                String photo = photoService.getPhotoForPost(idPost).getPhotoPath();
                User user = userService.getUserById(post.getIdAuthor());
//                int likeCount = likeService.countLikesForPost(idPost);
//                Like like = likeService.getLike(id, idPost);
                postViewModels.add(new PostViewModel(user.getIdUser(), user.getNickname(),
                        user.getProfilePhoto(), post, photo));
        });
        return postViewModels;
    }

    @Override
    public List<PostViewModel> getHomePosts(Integer id, Integer pageNo, Integer pageSize) {
        List<PostViewModel> postViewModels = new ArrayList<>();
        List<Post> posts = new ArrayList<>();
        posts.addAll(postService.getPostsForFeed(id, pageNo, pageSize));
        posts.forEach(post -> {
            int idPost = post.getIdPost();
            String photo = photoService.getPhotoForPost(idPost).getPhotoPath();
//            int likeCount = likeService.countLikesForPost(idPost);
//            Like like = likeService.getLike(id, idPost);
            postViewModels.add(new PostViewModel(id.intValue(), "",
                    "", post, photo));
        });
        return postViewModels;
    }

    @Override
    public void addPost(PostViewModel postViewModel) {
        Post newPost = postViewModel.getPost();
        Post post = postService.savePost(newPost);
        Photo newPhoto = new Photo();
        newPhoto.setIdPost(post.getIdPost());
        newPhoto.setPhotoPath(postViewModel.getPhotoPath());
        photoService.addPhoto(new Photo(postViewModel.getPhotoPath(), post.getIdPost()));
    }
}