package com.netcracker.ivanmerkush.backend.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.Objects;

@Entity
@Table(name = "post_hashtag", schema = "mydb", catalog = "")
public class PostHashtagEntity {
    private int idPostHashtag;

    @Id
    @Column(name = "id_post_hashtag")
    public int getIdPostHashtag() {
        return idPostHashtag;
    }

    public void setIdPostHashtag(int idPostHashtag) {
        this.idPostHashtag = idPostHashtag;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        PostHashtagEntity that = (PostHashtagEntity) o;
        return idPostHashtag == that.idPostHashtag;
    }

    @Override
    public int hashCode() {
        return Objects.hash(idPostHashtag);
    }
}
