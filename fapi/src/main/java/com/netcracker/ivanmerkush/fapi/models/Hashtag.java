package com.netcracker.ivanmerkush.fapi.models;

import javax.validation.constraints.Max;

public class Hashtag {
    private int idHashtag;
    @Max(value = 15, message = "Hashtag is too long")
    private String text;

    public Hashtag() {

    }

    public Hashtag(String text) {
        this.text = text;
    }

    public int getIdHashtag() {
        return idHashtag;
    }

    public void setIdHashtag(int idHashtag) {
        this.idHashtag = idHashtag;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }
}
