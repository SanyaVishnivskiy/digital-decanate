package com.example.app.api.user.Models;

public class PasswordNotMatchException extends Exception {
    public PasswordNotMatchException() {
    }

    public PasswordNotMatchException(String message) {
        super(message);
    }
}
