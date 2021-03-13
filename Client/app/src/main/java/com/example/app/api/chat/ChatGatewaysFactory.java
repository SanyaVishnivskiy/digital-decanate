package com.example.app.api.chat;

import com.example.app.api.stubs.chats.GlobalChatGatewayStub;

public class ChatGatewaysFactory {
    public IGlobalChatGateway createGlobalChatGateway(){
        return new GlobalChatGatewayStub();
    }
}
