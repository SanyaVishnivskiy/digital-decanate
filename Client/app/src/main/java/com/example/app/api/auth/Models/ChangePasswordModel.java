package com.example.app.api.auth.Models;

public class ChangePasswordModel {
    private String email;
    private String oldPassword;
    private String newPassword;
    private String confirmPassword;

    public String getEmail() {
        return email;
    }

    public String getOldPassword() {
        return oldPassword;
    }

    public String getNewPassword() {
        return newPassword;
    }

    public String getConfirmPassword() {
        return confirmPassword;
    }

    public ChangePasswordModel(String email, String oldPassword, String newPassword, String confirmPassword) {
        this.email = email;
        this.oldPassword = oldPassword;
        this.newPassword = newPassword;
        this.confirmPassword = confirmPassword;
    }
}
