package com.webshop.models;

public class UserLog {
    private String email;
    private String password;

    public String getEmail() {
        return email;
    }

    public UserLog setEmail(String email) {
        this.email = email;
        return this;
    }

    public String getPassword() {
        return password;
    }

    public UserLog setPassword(String password) {
        this.password = password;
        return this;

    }

    @Override
    public String toString() {
        return "UserLog{" +
                "email='" + email + '\'' +
                ", password='" + password + '\'' +
                '}';
    }
}