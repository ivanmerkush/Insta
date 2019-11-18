package com.netcracker.ivanmerkush.backend.entity;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "like", schema = "mydb", catalog = "")
public class LikeEntity {
    private int idLike;
    private int idPost;
    private int idUser;

    @Id
    @Column(name = "id_like")
    public int getIdLike() {
        return idLike;
    }

    public void setIdLike(int idLike) {
        this.idLike = idLike;
    }

    @Basic
    @Column(name = "id_post")
    public int getIdPost() {
        return idPost;
    }

    public void setIdPost(int idPost) {
        this.idPost = idPost;
    }

    @Basic
    @Column(name = "id_user")
    public int getIdUser() {
        return idUser;
    }

    public void setIdUser(int idUser) {
        this.idUser = idUser;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        LikeEntity that = (LikeEntity) o;
        return idLike == that.idLike &&
                idPost == that.idPost &&
                idUser == that.idUser;
    }

    @Override
    public int hashCode() {
        return Objects.hash(idLike, idPost, idUser);
    }
}
