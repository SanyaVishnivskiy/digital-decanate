package com.example.app.api.stubs.user;

import com.example.app.api.user.IUserGateway;
import com.example.app.api.user.Models.User;

public class StubUserGateway implements IUserGateway {

    @Override
    public void addOrUpdate(User user) {
        UsersCollection.getInstance().add(user);
    }

    @Override
    public User getByToken(String token) {
        return getById(token);
    }

    @Override
    public User getById(String id) {
        return UsersCollection.getInstance().getById(id);
    }
}
