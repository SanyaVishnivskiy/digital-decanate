package com.example.app.logic.user;

import com.example.app.api.user.IUserGateway;
import com.example.app.api.user.Models.User;
import com.example.app.api.user.UserGatewayFactory;

public class UserContext implements IUserContext {
    IUserGateway userGateway;
    User currentUser;
    String token;

    private static UserContext instance = new UserContext();

    public static UserContext getInstance() {
        return instance;
    }

    private UserContext() {
        userGateway = new UserGatewayFactory().create();
    }

    @Override
    public boolean isAuthorized() {
        return currentUser != null;
    }

    @Override
    public User getCurrentUser() {
        return currentUser;
    }

    @Override
    public void setToken(String token) {
        this.token = token;
        refreshUser();
    }

    public void refreshUser() {
        //TODO: handle case when token expired
        currentUser = userGateway.getByToken(token);
    }
}
