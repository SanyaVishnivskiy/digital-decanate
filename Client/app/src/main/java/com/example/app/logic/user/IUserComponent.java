package com.example.app.logic.user;

import com.example.app.api.user.Models.InvalidPasswordException;
import com.example.app.api.user.Models.PasswordNotMatchException;
import com.example.app.api.user.Models.User;
import com.example.app.api.user.Models.UserWithChangePasswordModel;
import com.example.app.api.user.Models.UserWithPassword;

public interface IUserComponent {
    User getCurrentUser();
    void save(UserWithChangePasswordModel user) throws PasswordNotMatchException, InvalidPasswordException;
    void save(UserWithPassword user);
}
