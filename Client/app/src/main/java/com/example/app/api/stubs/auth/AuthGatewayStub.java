package com.example.app.api.stubs.auth;

import com.example.app.api.auth.IAuthGateway;
import com.example.app.api.auth.Models.AuthModel;
import com.example.app.api.auth.Models.ChangePasswordModel;

public class AuthGatewayStub implements IAuthGateway {
    @Override
    public String authenticate(AuthModel model) {
        return null;
    }

    @Override
    public void changePassword(ChangePasswordModel model) {

    }
}
