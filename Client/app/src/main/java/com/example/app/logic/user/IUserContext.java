package com.example.app.logic.user;

import com.example.app.api.groups.Models.Group;
import com.example.app.api.user.Models.User;

public interface IUserContext {
    boolean isAuthorized();
    User getCurrentUser();
    Group getCurrentUserGroup();

    void setToken(String token);
}
