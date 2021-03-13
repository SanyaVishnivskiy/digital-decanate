package com.example.app.api.chat;

import com.example.app.api.chat.Models.Message;

import java.util.List;

public interface IGlobalChatGateway {
    List<Message> getMessages();
    void Send(Message message);
}
