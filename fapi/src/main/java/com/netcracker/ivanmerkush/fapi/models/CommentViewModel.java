package com.netcracker.ivanmerkush.fapi.models;

public class CommentViewModel {
    private String nickname;
    private String profilePhoto;
    private Comment comment;

    public CommentViewModel() {

    }

    public CommentViewModel(String nickname, String profilePhoto, Comment comment) {
        this.nickname = nickname;
        this.profilePhoto = profilePhoto;
        this.comment = comment;
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

    public Comment getComment() {
        return comment;
    }

    public void setComment(Comment comment) {
        this.comment = comment;
    }
}
