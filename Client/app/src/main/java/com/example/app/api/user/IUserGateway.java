package com.example.app.api.user;

public interface IUserGateway {
    void addOrUpdate(User user);
    User getByToken(String token);
    User getById(String id);
}
