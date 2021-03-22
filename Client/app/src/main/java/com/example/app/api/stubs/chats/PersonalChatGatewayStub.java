package com.example.app.api.stubs.chats;

import com.example.app.api.chat.IPersonalChatGateway;
import com.example.app.api.chat.Models.Chat;
import com.example.app.api.chat.Models.Message;

import java.util.List;

public class PersonalChatGatewayStub implements IPersonalChatGateway {
    @Override
    public List<Message> getMessages() {
        return null;
    }

    @Override
    public Chat getChatById(String id) {
        return null;
    }

    @Override
    public void send(Message message) {

    }
}
