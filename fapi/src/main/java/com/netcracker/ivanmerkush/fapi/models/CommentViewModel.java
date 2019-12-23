package com.netcracker.ivanmerkush.fapi.models;

import java.util.Date;

public class CommentViewModel {
    private String nickname;
    private String profilePhoto;
    private int idComment;
    private String text;
    private Date date;
    private int idAuthor;
    private int idPost;

    public CommentViewModel() {

    }

    public CommentViewModel(String nickname, String profilePhoto, int idComment, String text, Date date, int idAuthor, int idPost) {
        this.nickname = nickname;
        this.profilePhoto = profilePhoto;
        this.idComment = idComment;
        this.text = text;
        this.date = date;
        this.idAuthor = idAuthor;
        this.idPost = idPost;
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

    public int getIdComment() {
        return idComment;
    }

    public void setIdComment(int idComment) {
        this.idComment = idComment;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public int getIdAuthor() {
        return idAuthor;
    }

    public void setIdAuthor(int idAuthor) {
        this.idAuthor = idAuthor;
    }

    public int getIdPost() {
        return idPost;
    }

    public void setIdPost(int idPost) {
        this.idPost = idPost;
    }
}
