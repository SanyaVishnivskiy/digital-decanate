package com.example.app.api.auth;

import com.example.app.api.stubs.auth.AuthGatewayStub;

public class AuthGatewayFactory {
    public IAuthGateway create() {
        return new AuthGatewayStub();
    }
}
