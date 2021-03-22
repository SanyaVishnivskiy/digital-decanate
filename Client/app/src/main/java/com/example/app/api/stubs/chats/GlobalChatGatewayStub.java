package com.example.app.api.stubs.chats;

import com.example.app.api.chat.IGlobalChatGateway;
import com.example.app.api.chat.Models.Message;

import java.util.List;

public class GlobalChatGatewayStub implements IGlobalChatGateway {

    @Override
    public List<Message> getMessages() {
        return null;
    }

    @Override
    public void send(Message message) {

    }
}
