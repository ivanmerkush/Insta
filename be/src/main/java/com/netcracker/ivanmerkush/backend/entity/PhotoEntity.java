package com.netcracker.ivanmerkush.backend.entity;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "photo", schema = "mydb", catalog = "")
public class PhotoEntity {
    private int idPhoto;
    private String photoPath;
    private int idPost;

    @Id
    @Column(name = "id_photo")
    public int getIdPhoto() {
        return idPhoto;
    }

    public void setIdPhoto(int idPhoto) {
        this.idPhoto = idPhoto;
    }

    @Basic
    @Column(name = "photo_path")
    public String getPhotoPath() {
        return photoPath;
    }

    public void setPhotoPath(String photoPath) {
        this.photoPath = photoPath;
    }

    @Basic
    @Column(name = "id_post")
    public int getIdPost() {
        return idPost;
    }

    public void setIdPost(int idPost) {
        this.idPost = idPost;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        PhotoEntity that = (PhotoEntity) o;
        return idPhoto == that.idPhoto &&
                idPost == that.idPost &&
                Objects.equals(photoPath, that.photoPath);
    }

    @Override
    public int hashCode() {
        return Objects.hash(idPhoto, photoPath, idPost);
    }
}
