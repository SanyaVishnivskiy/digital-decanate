package com.example.app.api.user;

import java.util.concurrent.ExecutionException;

public class StubUserGateway implements IUserGateway {

    @Override
    public User getCurrentUser() throws ExecutionException, InterruptedException {
        return new User(
                "1",
                "name",
                "lastname",
                "user");
    }
}
