package com.example.app.api.chat;

import com.example.app.api.chat.Models.Chat;
import com.example.app.api.chat.Models.Message;

import java.util.List;

public interface IPersonalChatGateway {
    List<Message> getMessages();
    Chat getChatById(String id);
    void Send(Message message);
}
