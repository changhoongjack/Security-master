package com.example.jack.security;

public class UserDetails {
    String name;
    String ic;
    String phone;
    String email;

    public UserDetails() {
    }

    public UserDetails(String name, String ic, String phone, String email) {
        this.name = name;
        this.ic = ic;
        this.phone = phone;
        this.email = email;
    }

    public String getName() {
        return name;
    }

    public String getIc() {
        return ic;
    }

    public String getPhone() {
        return phone;
    }

    public String getEmail() {
        return email;
    }
}
