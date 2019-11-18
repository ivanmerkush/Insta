package com.netcracker.ivanmerkush.backend.entity;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "hashtag", schema = "mydb", catalog = "")
public class HashtagEntity {
    private int idHashtag;
    private String text;

    @Id
    @Column(name = "id_hashtag")
    public int getIdHashtag() {
        return idHashtag;
    }

    public void setIdHashtag(int idHashtag) {
        this.idHashtag = idHashtag;
    }

    @Basic
    @Column(name = "text")
    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        HashtagEntity that = (HashtagEntity) o;
        return idHashtag == that.idHashtag &&
                Objects.equals(text, that.text);
    }

    @Override
    public int hashCode() {
        return Objects.hash(idHashtag, text);
    }
}
