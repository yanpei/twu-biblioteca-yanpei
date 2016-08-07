package com.twu.biblioteca.Model;

public class User {
    private String libraryNumber;
    private String password;
    private boolean isLogin;
    private String name;
    private String emaiAddress;
    private String phoneNumber;

    public User(String libararyNumber, String password, String name, String emailAddress, String phoneNumber) {
        this.libraryNumber = libararyNumber;
        this.password = password;
        this.name = name;
        this.emaiAddress = emailAddress;
        this.phoneNumber = phoneNumber;
    }

    public String getLibraryNumber() {
        return libraryNumber;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public boolean isLogin() {
        return isLogin;
    }

    public void setLogin(boolean login) {
        isLogin = login;
    }

    public String getName() {
        return name;
    }

    public String getEmaiAddress() {
        return emaiAddress;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }
}
