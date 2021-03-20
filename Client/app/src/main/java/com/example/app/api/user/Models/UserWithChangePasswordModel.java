package com.example.app.api.user.Models;

import com.example.app.api.auth.Models.ChangePasswordModel;

public class UserWithChangePasswordModel extends User {
    public ChangePasswordModel getChangePasswordModel() {
        return changePasswordModel;
    }

    private ChangePasswordModel changePasswordModel;

    public UserWithChangePasswordModel(String id, String name, String lastName, String phoneNumber, String email, String studentTicket, String groupId, String faculty, int course, String role, ChangePasswordModel model) {
        super(id, name, lastName, phoneNumber, email, studentTicket, groupId, faculty, course, role);
        this.changePasswordModel = model;
    }
}
