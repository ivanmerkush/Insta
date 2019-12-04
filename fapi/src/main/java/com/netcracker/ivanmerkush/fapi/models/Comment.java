package com.netcracker.ivanmerkush.fapi.models;

import java.sql.Timestamp;

public class Comment {
    private int idComment;
    private String text;
    private Timestamp dateTime;

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

}

