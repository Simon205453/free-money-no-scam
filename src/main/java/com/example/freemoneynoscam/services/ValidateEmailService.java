package com.example.freemoneynoscam.services;

public class ValidateEmailService {
    public boolean isEmailValid(String email){
        if(email.contains("@")){
            if (email.contains(".")){
                return true;
            }
        } else {
            System.out.println("invalid email");
            return false;
        }
        return false;
    }

}
