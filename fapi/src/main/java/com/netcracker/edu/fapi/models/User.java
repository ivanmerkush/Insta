package com.netcracker.edu.fapi.models;

public class User {
    private int _id;
    private String _nickname;
    private String _name;
    private String _email;
    private String _bio;
    private String _subscribers;
    private String _subscriptions;
    private String _userPhoto;

    public User(int _id, String _nickname, String _name, String _email, String _bio, String _subscribers, String _subscriptions, String _userPhoto) {
        this._id = _id;
        this._nickname = _nickname;
        this._name = _name;
        this._email = _email;
        this._bio = _bio;
        this._subscribers = _subscribers;
        this._subscriptions = _subscriptions;
        this._userPhoto = _userPhoto;
    }

    public int get_id() {
        return _id;
    }

    public void set_id(int _id) {
        this._id = _id;
    }

    public String get_nickname() {
        return _nickname;
    }

    public void set_nickname(String _nickname) {
        this._nickname = _nickname;
    }

    public String get_name() {
        return _name;
    }

    public void set_name(String _name) {
        this._name = _name;
    }

    public String get_email() {
        return _email;
    }

    public void set_email(String _email) {
        this._email = _email;
    }

    public String get_bio() {
        return _bio;
    }

    public void set_bio(String _bio) {
        this._bio = _bio;
    }

    public String get_subscribers() {
        return _subscribers;
    }

    public void set_subscribers(String _subscribers) {
        this._subscribers = _subscribers;
    }

    public String get_subscriptions() {
        return _subscriptions;
    }

    public void set_subscriptions(String _subscriptions) {
        this._subscriptions = _subscriptions;
    }

    public String get_userPhoto() {
        return _userPhoto;
    }

    public void set_userPhoto(String _userPhoto) {
        this._userPhoto = _userPhoto;
    }

    @Override
    public String toString() {
        return "User{" +
                "_id=" + _id +
                ", _nickname='" + _nickname + '\'' +
                ", _name='" + _name + '\'' +
                ", _email='" + _email + '\'' +
                ", _bio='" + _bio + '\'' +
                ", _subscribers='" + _subscribers + '\'' +
                ", _subscriptions='" + _subscriptions + '\'' +
                ", _userPhoto='" + _userPhoto + '\'' +
                '}';
    }
}
