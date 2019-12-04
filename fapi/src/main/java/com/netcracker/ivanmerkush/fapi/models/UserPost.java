package com.netcracker.ivanmerkush.fapi.models;

public class UserPost {
    private int idUser;
    private String nickname;

    private Post post;

    public UserPost() {

    }

    public UserPost(int idUser, String nickname, Post post) {
        this.idUser = idUser;
        this.nickname = nickname;
        this.post = post;
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

    public Post getPost() {
        return post;
    }

    public void setPost(Post post) {
        this.post = post;
    }
}
