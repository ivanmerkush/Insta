package com.netcracker.ivanmerkush.fapi.models;

import javax.validation.constraints.Max;
import java.sql.Timestamp;

public class Comment {
    private int idComment;
    @Max(value = 225, message = "Comment is too big(<225)")
    private String text;

    private Timestamp dateTime;
    private int idPost;
    private int idAuthor;

    public Comment() {

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


    public Timestamp getDateTime() {
        return dateTime;
    }

    public void setDateTime(Timestamp dateTime) {
        this.dateTime = dateTime;
    }


    public int getIdPost() {
        return idPost;
    }

    public void setIdPost(int idPost) {
        this.idPost = idPost;
    }

    public int getIdAuthor() {
        return idAuthor;
    }

    public void setIdAuthor(int idAuthor) {
        this.idAuthor = idAuthor;
    }

}

