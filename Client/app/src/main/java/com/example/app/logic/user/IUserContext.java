package com.example.app.logic.user;

import com.example.app.api.user.Models.User;

public interface IUserContext {
    boolean isAuthorized();
    User getCurrentUser();

    void setToken(String token);
}
