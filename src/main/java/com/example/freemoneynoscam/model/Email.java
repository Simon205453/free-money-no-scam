package com.example.freemoneynoscam.model;

public class Email {
    String email;

    public Email(String email) {
        this.email = email;
    }

    public String getEmailString() {
        return email;
    }

    @Override
    public String toString() {
        return "Email{" +
                "email='" + email + '\'' +
                '}';
    }
}
