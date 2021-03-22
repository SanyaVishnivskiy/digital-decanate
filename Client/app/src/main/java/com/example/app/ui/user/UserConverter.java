package com.example.app.ui.user;

import com.example.app.api.auth.Models.ChangePasswordModel;
import com.example.app.api.user.Models.UserWithChangePasswordModel;
import com.example.app.api.user.Models.UserWithPassword;
import com.example.app.ui.createUser.CreateUserModelWithViews;

public class UserConverter {
    public UserWithChangePasswordModel convert(UserModelWithViews user){
        ChangePasswordModel passModel = toChangePasswordModel(user);
        return toUserWithChangePasswordModel(user, passModel);
    }

    private UserWithChangePasswordModel toUserWithChangePasswordModel(UserModelWithViews user, ChangePasswordModel passModel) {
        return new UserWithChangePasswordModel(
                String.valueOf(user.getId().getText()),
                String.valueOf(user.getName().getText()),
                String.valueOf(user.getLastName().getText()),
                String.valueOf(user.getPhoneNumber().getText()),
                String.valueOf(user.getEmail().getText()),
                String.valueOf(user.getStudentTicket().getText()),
                String.valueOf(user.getGroupName().getText()),
                String.valueOf(user.getFaculty().getText()),
                Integer.parseInt(String.valueOf(user.getCourse().getText())),
                String.valueOf(user.getRole().getText()),
                passModel
        );
    }

    private ChangePasswordModel toChangePasswordModel(UserModelWithViews user) {
        String newPass = String.valueOf(user.getNewPassword().getText());
        if (newPass == null || newPass.equals(""))
            return null;

        return new ChangePasswordModel(
                String.valueOf(user.getEmail().getText()),
                String.valueOf(user.getOldPassword().getText()),
                String.valueOf(user.getNewPassword().getText()),
                String.valueOf(user.getConfirmPassword().getText())
        );
    }

    public UserWithPassword convert(CreateUserModelWithViews user) {
        return new UserWithPassword(
                String.valueOf(user.getId().getText()),
                String.valueOf(user.getName().getText()),
                String.valueOf(user.getLastName().getText()),
                String.valueOf(user.getPhoneNumber().getText()),
                String.valueOf(user.getEmail().getText()),
                String.valueOf(user.getStudentTicket().getText()),
                String.valueOf(user.getGroupName().getText()),
                String.valueOf(user.getFaculty().getText()),
                Integer.parseInt(String.valueOf(user.getCourse().getText())),
                String.valueOf(user.getRole().getText()),
                String.valueOf(user.getPassword().getText())
        );
    }
}
