package com.twu.biblioteca.Model;

/**
 * Created by pyan on 8/2/16.
 */
public class User {
    private String libraryNumber;
    private String password;
    private boolean isLogin;

    public User(String libraryNumber, String password,boolean isLogin) {
        this.libraryNumber = libraryNumber;
        this.password = password;
        this.isLogin = isLogin;
    }

    public User() {

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
}
