package com.netcracker.ivanmerkush.backend.model;

import com.netcracker.ivanmerkush.backend.entity.CommentEntity;

public class CommentViewModel {
    private String nickname;
    private String profilePhoto;
    private CommentEntity comment;

    public CommentViewModel() {

    }

    public CommentViewModel(String nickname, String profilePhoto, CommentEntity comment) {
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

    public CommentEntity getComment() {
        return comment;
    }

    public void setComment(CommentEntity comment) {
        this.comment = comment;
    }
}
