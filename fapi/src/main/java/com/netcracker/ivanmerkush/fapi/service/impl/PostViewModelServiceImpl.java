package com.netcracker.ivanmerkush.fapi.service.impl;

import com.netcracker.ivanmerkush.fapi.models.*;
import com.netcracker.ivanmerkush.fapi.service.*;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

@Service
public class PostViewModelServiceImpl implements PostViewModelService {


    private UserService userService;
    private PostService postService;
    private PhotoService photoService;
    private LikeService likeService;
    private HashtagService hashtagService;
    public PostViewModelServiceImpl(UserService userService, PostService postService, HashtagService hashtagService,
                                    PhotoService photoService, LikeService likeService) {
        this.userService = userService;
        this.postService = postService;
        this.hashtagService = hashtagService;
        this.photoService = photoService;
        this.likeService = likeService;
    }

    @Override
    public PageViewModel getFeedPosts(Integer id, Integer pageNo, Integer pageSize) {
        List<PostViewModel> postViewModels = new ArrayList<>();
        PageModel pageModel = postService.getPostsForFeed(id, pageNo, pageSize);
        pageModel.getPage().forEach(post -> {
            int idPost = post.getIdPost();
            String photo = photoService.getPhotoForPost(idPost).getPhotoPath();
            User user = userService.getUserById(post.getIdAuthor());
            int likeCount = likeService.countLikesForPost(idPost);
            Like like = likeService.getLike(id, idPost);
            postViewModels.add(new PostViewModel(user.getIdUser(), user.getNickname(),
                                user.getProfilePhoto(), post, photo, likeCount, like));
        });
        PageViewModel pageViewModel = new PageViewModel(pageModel.getTotalElements(), postViewModels);
        return pageViewModel;
    }

    @Override
    public PageViewModel getHomePosts(Integer id, Integer pageNo, Integer pageSize) {
        List<PostViewModel> postViewModels = new ArrayList<>();
        PageModel pageModel = postService.getPostsForHome(id, pageNo, pageSize);
        pageModel.getPage().forEach(post -> {
            int idPost = post.getIdPost();
            String photo = photoService.getPhotoForPost(idPost).getPhotoPath();
            User user = userService.getUserById(post.getIdAuthor());
            int likeCount = likeService.countLikesForPost(idPost);
            Like like = likeService.getLike(id, idPost);
            postViewModels.add(new PostViewModel(id.intValue(), user.getNickname(),
                    user.getProfilePhoto(), post, photo, likeCount, like));
        });
        PageViewModel pageViewModel = new PageViewModel(pageModel.getTotalElements(), postViewModels);
        return pageViewModel;
    }

    @Override
    public PageViewModel getHashtagPosts(Integer idHashtag, Integer pageNo, Integer pageSize) {
        List<PostViewModel> postViewModels = new ArrayList<>();
        PageModel pageModel = postService.getPostsForHashtag(idHashtag, pageNo, pageSize);

        pageModel.getPage().forEach(post -> {
            int idPost = post.getIdPost();
            String photo = photoService.getPhotoForPost(idPost).getPhotoPath();
            User user = userService.getUserById(post.getIdAuthor());
            int likeCount = likeService.countLikesForPost(idPost);
            Like like = likeService.getLike(user.getIdUser(), idPost);
            postViewModels.add(new PostViewModel(user.getIdUser(), user.getNickname(),
                    user.getProfilePhoto(), post, photo, likeCount, like));
        });
        PageViewModel pageViewModel = new PageViewModel(pageModel.getTotalElements(), postViewModels);
        return pageViewModel;
    }

    @Override
    public PostViewModel getPostByIdPost(Integer idUser, Integer idPost) {
        PostViewModel postViewModel;
        Post post = postService.getPostByIdPost(idPost);
        if(post == null) {
            return null;
        }
        String photo = photoService.getPhotoForPost(idPost).getPhotoPath();
        User user = userService.getUserById(post.getIdAuthor());
        int likeCount = likeService.countLikesForPost(idPost);
        Like like = likeService.getLike(idUser, idPost);
        postViewModel = new PostViewModel(user.getIdUser(), user.getNickname(),
                user.getProfilePhoto(), post, photo, likeCount, like);
        return postViewModel;
    }

    @Override
    public List<PostViewModel> getMostLikedPosts() {
        List<Post> posts = postService.getAllPosts();
        List<PostViewModel> list = new ArrayList<>();
        int best = 0;
        for (Post post: posts) {
            int idPost = post.getIdPost();
            String photo = photoService.getPhotoForPost(idPost).getPhotoPath();
            User user = userService.getUserById(post.getIdAuthor());
            int likeCount = likeService.countLikesForPost(idPost);
            if(best < likeCount) {
                best = likeCount;
            }
            Like like = likeService.getLike(user.getIdUser(), idPost);
            list.add(new PostViewModel(user.getIdUser(), user.getNickname(),
                    user.getProfilePhoto(), post, photo, likeCount, like));
        }
        List<PostViewModel> result = new ArrayList<>();
        for( PostViewModel postViewModel: list) {
            if(postViewModel.getLikeCount() == best) {
                result.add(postViewModel);
            }
        };
        return result;
    }

    @Override
    public void savePost(PostViewModel postViewModel) {
        Post newPost = postViewModel.getPost();
        Post post = postService.savePost(newPost);

        Pattern pattern = Pattern.compile("#(.[^\\s]*)");
        Matcher matcher = pattern.matcher(post.getText());

        while (matcher.find()) {
            Hashtag hashtag = hashtagService.getHashtagByText(matcher.group(1));
            if(hashtag == null) {
                hashtag = hashtagService.saveHashtag(new Hashtag(matcher.group(1)));
            }
            hashtagService.savePostAndHashtag(post.getIdPost(), hashtag.getIdHashtag());
        }
        Photo newPhoto = new Photo();
        newPhoto.setIdPost(post.getIdPost());
        newPhoto.setPhotoPath(postViewModel.getPhotoPath());
        photoService.addPhoto(new Photo(postViewModel.getPhotoPath(), post.getIdPost()));
    }
}