package com.example.app.api.user;

import com.example.app.api.stubs.user.StubUserGateway;

public class UserGatewayFactory {
    public IUserGateway create() {
        return new StubUserGateway();
    }
}
