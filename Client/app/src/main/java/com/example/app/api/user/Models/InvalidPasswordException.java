package com.example.app.api.user.Models;

public class InvalidPasswordException extends Exception {
    public InvalidPasswordException() {
    }

    public InvalidPasswordException(String message) {
        super(message);
    }
}
