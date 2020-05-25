package com.netcracker.ivanmerkush.fapi.models;

public class ComplaintViewModel {
    private String prosecutorNickname;
    private String prosecutorPhoto;
    private String accusedNickname;
    private String accusedPhoto;
    private Complaint complaint;

    public ComplaintViewModel(String prosecutorNickname, String prosecutorPhoto, String accusedNickname, String accusedPhoto, Complaint complaint) {
        this.prosecutorNickname = prosecutorNickname;
        this.prosecutorPhoto = prosecutorPhoto;
        this.accusedNickname = accusedNickname;
        this.accusedPhoto = accusedPhoto;
        this.complaint = complaint;
    }

    public String getProsecutorNickname() {
        return prosecutorNickname;
    }

    public void setProsecutorNickname(String prosecutorNickname) {
        this.prosecutorNickname = prosecutorNickname;
    }

    public String getProsecutorPhoto() {
        return prosecutorPhoto;
    }

    public void setProsecutorPhoto(String prosecutorPhoto) {
        this.prosecutorPhoto = prosecutorPhoto;
    }

    public String getAccusedNickname() {
        return accusedNickname;
    }

    public void setAccusedNickname(String accusedNickname) {
        this.accusedNickname = accusedNickname;
    }

    public String getAccusedPhoto() {
        return accusedPhoto;
    }

    public void setAccusedPhoto(String accusedPhoto) {
        this.accusedPhoto = accusedPhoto;
    }

    public Complaint getComplaint() {
        return complaint;
    }

    public void setComplaint(Complaint complaint) {
        this.complaint = complaint;
    }
}
