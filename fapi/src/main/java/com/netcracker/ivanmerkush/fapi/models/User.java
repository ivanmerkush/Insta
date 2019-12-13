package com.netcracker.ivanmerkush.fapi.models;

public class User {
    private int idUser;
    private String nickname;
    private String name;
    private String password;
    private String email;
    private String info;
    private Role role;
    private Status status;
    private String profilePhoto;
    public User() {

    }


    public User(int _id, String _nickname, String _name, String _password, String _email, String _bio, Role role, Status status,String _userPhoto) {
        this.idUser = _id;
        this.nickname = _nickname;
        this.name = _name;
        this.password = _password;
        this.email = _email;
        this.info = _bio;
        this.role = role;
        this.status = status;
        this.profilePhoto = _userPhoto;
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

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
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

    public Role getRole() {
        return role;
    }

    public void setRole(Role role) {
        this.role = role;
    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }

    public String getProfilePhoto() {
        return profilePhoto;
    }

    public void setProfilePhoto(String profilePhoto) {
        this.profilePhoto = profilePhoto;
    }

    @Override
    public String toString() {
        return "User{" +
                "idUser=" + idUser +
                ", nickname='" + nickname + '\'' +
                ", name='" + name + '\'' +
                ", password='" + password + '\'' +
                ", email='" + email + '\'' +
                ", info='" + info + '\'' +
                ", role=" + role +
                ", status=" + status +
                ", profilePhoto='" + profilePhoto + '\'' +
                '}';
    }
}

enum Role {
    ADMIN,
    CUSTOMER
}

enum Status {
    ACTIVE,
    BANNED
}