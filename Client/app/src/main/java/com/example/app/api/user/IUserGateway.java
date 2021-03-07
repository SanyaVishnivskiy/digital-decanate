package com.example.app.api.user;

import java.util.concurrent.ExecutionException;

public interface IUserGateway {
    User getCurrentUser() throws ExecutionException, InterruptedException;
}
