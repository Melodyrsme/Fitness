package com.company.fitnessproject.exception;

public class UserCheckPassword extends RuntimeException{
    public UserCheckPassword(String message) {
        super(message);
    }
}
