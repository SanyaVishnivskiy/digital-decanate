package com.example.app.api.auth;

import com.example.app.api.auth.Models.AuthModel;
import com.example.app.api.auth.Models.ChangePasswordModel;
import com.example.app.api.user.Models.InvalidPasswordException;
import com.example.app.api.user.Models.PasswordNotMatchException;

public interface IAuthGateway {
    String authenticate(AuthModel model);
    void changePassword(ChangePasswordModel model) throws InvalidPasswordException, PasswordNotMatchException;
}
