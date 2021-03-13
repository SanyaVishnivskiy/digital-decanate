package com.example.app.api.auth;

import com.example.app.api.auth.Models.AuthModel;
import com.example.app.api.auth.Models.ChangePasswordModel;

public interface IAuthGateway {
    String authenticate(AuthModel model);
    void changePassword(ChangePasswordModel model);
}
