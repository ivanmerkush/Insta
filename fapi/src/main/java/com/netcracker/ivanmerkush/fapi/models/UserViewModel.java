package com.netcracker.ivanmerkush.fapi.models;

public class UserViewModel {
    private int idUser;
    private String nickname;
    private String name;
    private String email;
    private String info;
    private String profilePhoto;
    private int numberOfPosts;
    private int subscribers;
    private int subscriptions;

    public UserViewModel() {

    }

    public UserViewModel(int idUser, String nickname, String name, String email, String info,
                         String profilePhoto, int numberOfPosts, int subscribers, int subscriptions) {
        this.idUser = idUser;
        this.nickname = nickname;
        this.name = name;
        this.email = email;
        this.info = info;
        this.profilePhoto = profilePhoto;
        this.numberOfPosts = numberOfPosts;
        this.subscribers = subscribers;
        this.subscriptions = subscriptions;
    }

    public int getIdUser() {
        return idUser;
    }

    public void setIdUser(int idUser) {
        this.idUser = idUser;
    }

    public String getNickname() {
        return nickname;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getInfo() {
        return info;
    }

    public void setInfo(String info) {
        this.info = info;
    }

    public String getProfilePhoto() {
        return profilePhoto;
    }

    public void setProfilePhoto(String profilePhoto) {
        this.profilePhoto = profilePhoto;
    }

    public int getNumberOfPosts() {
        return numberOfPosts;
    }

    public void setNumberOfPosts(int numberOfPosts) {
        this.numberOfPosts = numberOfPosts;
    }

    public int getSubscribers() {
        return subscribers;
    }

    public void setSubscribers(int subscribers) {
        this.subscribers = subscribers;
    }

    public int getSubscriptions() {
        return subscriptions;
    }

    public void setSubscriptions(int subscriptions) {
        this.subscriptions = subscriptions;
    }
}
