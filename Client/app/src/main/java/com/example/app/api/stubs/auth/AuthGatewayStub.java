package com.example.app.api.stubs.auth;

import com.example.app.api.auth.IAuthGateway;
import com.example.app.api.auth.Models.AuthModel;
import com.example.app.api.auth.Models.ChangePasswordModel;
import com.example.app.api.stubs.user.UsersCollection;
import com.example.app.api.user.Models.UserWithPassword;
import com.example.app.api.user.Models.User;

public class AuthGatewayStub implements IAuthGateway {
    @Override
    public String authenticate(AuthModel model) {
        User user = UsersCollection.getInstance().getByEmail(model.getEmail());
        if (user == null)
            return null;

        if (!(user instanceof UserWithPassword)){
            return user.getId();
        }

        UserWithPassword userWithPassword = (UserWithPassword) user;
        if (userWithPassword.getPassword() == model.getPassword()){
            return user.getId();
        }

        return null;
    }

    @Override
    public void changePassword(ChangePasswordModel model) {

    }
}
