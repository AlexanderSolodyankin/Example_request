package com.example.demo.models;

public class UserModel {
    private long id;
    private String login;
    private String password;
    private String email;
    private PersoneModel infoUser;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
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

    public PersoneModel getInfoUser() {
        return infoUser;
    }

    public void setInfoUser(PersoneModel infoUser) {
        this.infoUser = infoUser;
    }
}
