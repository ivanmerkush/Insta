package com.netcracker.ivanmerkush.fapi.models;

public class PostHashtag {
    private int idPostHashtag;
    private int idPost;
    private int idHashtag;

    public PostHashtag() {

    }

    public PostHashtag(int idPost, int idHashtag) {
        this.idPost = idPost;
        this.idHashtag = idHashtag;
    }

    public int getIdPostHashtag() {
        return idPostHashtag;
    }

    public void setIdPostHashtag(int idPostHashtag) {
        this.idPostHashtag = idPostHashtag;
    }

    public int getIdPost() {
        return idPost;
    }

    public void setIdPost(int idPost) {
        this.idPost = idPost;
    }

    public int getIdHashtag() {
        return idHashtag;
    }

    public void setIdHashtag(int idHashtag) {
        this.idHashtag = idHashtag;
    }
}
