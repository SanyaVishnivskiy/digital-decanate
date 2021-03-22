package com.example.app.api.chat;

import com.example.app.api.chat.Models.Chat;

import java.util.List;

public interface IChatListGateway {
    List<Chat> getChats(String userId);
    void add(Chat chat);
}
