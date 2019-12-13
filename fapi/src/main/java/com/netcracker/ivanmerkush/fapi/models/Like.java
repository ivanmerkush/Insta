package com.netcracker.ivanmerkush.fapi.models;

public class Like {
    private int idLike;
    private int idPost;
    private int idUser;

    public Like(int idLike, int idPost, int idUser) {
        this.idLike = idLike;
        this.idPost = idPost;
        this.idUser = idUser;
    }

    public int getIdLike() {
        return idLike;
    }

    public void setIdLike(int idLike) {
        this.idLike = idLike;
    }

    public int getIdPost() {
        return idPost;
    }

    public void setIdPost(int idPost) {
        this.idPost = idPost;
    }

    public int getIdUser() {
        return idUser;
    }

    public void setIdUser(int idUser) {
        this.idUser = idUser;
    }
}
