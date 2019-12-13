package com.netcracker.ivanmerkush.fapi.models;

public class PostViewModel {
    private int idUser;
    private String nickname;
    private String profilePhoto;
    private Post post;
    private String photoPath;
//    private int likeCount;
//    private Like like;
    public PostViewModel() {

    }

    public PostViewModel(int idUser, String nickname, String profilePhoto, Post post, String photoPath){// int likeCount, Like like) {
        this.idUser = idUser;
        this.nickname = nickname;
        this.profilePhoto = profilePhoto;
        this.post = post;
        this.photoPath = photoPath;
//        this.likeCount = likeCount;
//        this.like = like;
    }



    public int getIdUser() {
        return idUser;
    }

    public void setIdUser(int idUser) {
        this.idUser = idUser;
    }

    public String getNickname() {
        return nickname;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
    }

    public String getProfilePhoto() {
        return profilePhoto;
    }

    public void setProfilePhoto(String profilePhoto) {
        this.profilePhoto = profilePhoto;
    }

    public Post getPost() {
        return post;
    }

    public void setPost(Post post) {
        this.post = post;
    }

    public String getPhotoPath() {
        return photoPath;
    }

    public void setPhotoPath(String photoPath) {
        this.photoPath = photoPath;
    }

//    public int getLikeCount() {
//        return likeCount;
//    }
//
//    public void setLikeCount(int likeCount) {
//        this.likeCount = likeCount;
//    }
//
//    public Like getLike() {
//        return like;
//    }
//
//    public void setLike(Like like) {
//        this.like = like;
//    }
}
