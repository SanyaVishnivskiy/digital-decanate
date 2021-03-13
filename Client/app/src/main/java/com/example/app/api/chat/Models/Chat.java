package com.example.app.api.chat.Models;

import com.example.app.api.user.User;

import java.util.List;

public class Chat {
    private String id;
    private List<Message> messages;
    private List<User> users;

    public Chat(String id, List<Message> messages, List<User> users) {
        this.id = id;
        this.messages = messages;
        this.users = users;
    }

    public List<Message> getMessages() {
        return messages;
    }

    public List<User> getUsers() {
        return users;
    }

    public String getId() {
        return id;
    }
}
