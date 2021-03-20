package com.example.app.api.user;

import com.example.app.api.user.Models.User;

public interface IUserGateway {
    void addOrUpdate(User user);
    User getByToken(String token);
    User getById(String id);
}
