package com.example.app.api.user;

import com.example.app.api.user.Models.UserWithPassword;

public interface IUserGateway {
    void addOrUpdate(UserWithPassword user);
    User getByToken(String token);
    User getById(String id);
}
