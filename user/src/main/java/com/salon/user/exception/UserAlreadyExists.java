package com.salon.user.exception;

public class UserAlreadyExists extends RuntimeException {
    public UserAlreadyExists(String s) {
        super(s);
    }
}
