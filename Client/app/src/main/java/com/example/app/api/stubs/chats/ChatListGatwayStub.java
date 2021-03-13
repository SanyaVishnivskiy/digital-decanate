package com.example.app.api.stubs.chats;

import com.example.app.api.chat.IChatListGateway;
import com.example.app.api.chat.Models.Chat;

import java.util.List;

public class ChatListGatwayStub implements IChatListGateway {
    @Override
    public List<Chat> getChats(String userId) {
        return null;
    }

    @Override
    public void add(Chat chat) {

    }
}
