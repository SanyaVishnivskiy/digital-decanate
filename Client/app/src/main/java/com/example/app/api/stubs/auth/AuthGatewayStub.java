package com.example.app.api.stubs.auth;

import android.os.Build;

import androidx.annotation.RequiresApi;

import com.example.app.api.auth.IAuthGateway;
import com.example.app.api.auth.Models.AuthModel;
import com.example.app.api.auth.Models.ChangePasswordModel;
import com.example.app.api.stubs.user.UsersCollection;
import com.example.app.api.user.Models.InvalidPasswordException;
import com.example.app.api.user.Models.PasswordNotMatchException;
import com.example.app.api.user.Models.UserWithPassword;
import com.example.app.api.user.User;

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

    @RequiresApi(api = Build.VERSION_CODES.N)
    @Override
    public void changePassword(ChangePasswordModel model) throws InvalidPasswordException, PasswordNotMatchException {
        User user = UsersCollection.getInstance().getByEmail(model.getEmail());
        if (user instanceof UserWithPassword) {
            ensureChangePasswordModelCorrect(user, model);
        }

        User updatedUser = new UserWithPassword(user, model.getNewPassword());
        UsersCollection.getInstance().update(updatedUser);
    }

    private void ensureChangePasswordModelCorrect(User user, ChangePasswordModel model) throws InvalidPasswordException, PasswordNotMatchException {
        UserWithPassword userWithPass = (UserWithPassword)user;
        if (!userWithPass.getPassword().equals(model.getOldPassword())) {
            throw new InvalidPasswordException();
        }
        if (!model.getNewPassword().equals(model.getConfirmPassword())){
            throw new PasswordNotMatchException();
        }
    }
}
