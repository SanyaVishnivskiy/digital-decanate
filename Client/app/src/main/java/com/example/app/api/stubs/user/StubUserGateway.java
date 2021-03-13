package com.example.app.api.stubs.user;

import com.example.app.api.user.IUserGateway;
import com.example.app.api.user.Models.UserWithPassword;
import com.example.app.api.user.User;

import java.util.concurrent.ExecutionException;

public class StubUserGateway implements IUserGateway {

    @Override
    public void addOrUpdate(UserWithPassword user) {

    }

    @Override
    public User getByToken(String token) {
        return null;
    }

    @Override
    public User getById(String id) {
        return new User(
                id,
                "name",
                "lastname",
                "09990005",
                "email@email.com",
                "454656",
                "1",
                "FKKPI",
                1,
                "user");
    }
}
