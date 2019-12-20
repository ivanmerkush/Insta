package com.netcracker.ivanmerkush.backend.entity;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "post_hashtag", schema = "mydb", catalog = "")
public class PostHashtagEntity {
    private int idPostHashtag;
    private int idPost;
    private int idHashtag;

    public PostHashtagEntity() {

    }

    public PostHashtagEntity( int idPost, int idHashtag) {
        this.idPost = idPost;
        this.idHashtag = idHashtag;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_post_hashtag")
    public int getIdPostHashtag() {
        return idPostHashtag;
    }

    public void setIdPostHashtag(int idPostHashtag) {
        this.idPostHashtag = idPostHashtag;
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
    @Column(name = "id_hashtag")
    public int getIdHashtag() {
        return idHashtag;
    }

    public void setIdHashtag(int idHashtag) {
        this.idHashtag = idHashtag;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        PostHashtagEntity that = (PostHashtagEntity) o;
        return idPostHashtag == that.idPostHashtag &&
                idPost == that.idPost &&
                idHashtag == that.idHashtag;
    }

    @Override
    public int hashCode() {
        return Objects.hash(idPostHashtag, idPost, idHashtag);
    }
}
