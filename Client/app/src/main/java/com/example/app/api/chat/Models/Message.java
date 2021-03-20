package com.example.app.api.chat.Models;

import com.example.app.api.user.Models.User;

import java.util.Date;

public class Message {
    private String id;
    private String message;
    private Date dateTime;
    private String chatid;
    private User user;

    public Message(String id, String message, Date dateTime, String chatid, User user) {
        this.id = id;
        this.message = message;
        this.dateTime = dateTime;
        this.chatid = chatid;
        this.user = user;
    }

    public String getChatid() {
        return chatid;
    }

    public String getId(){
        return id;
    }

    public Date getDateTime() {
        return dateTime;
    }

    public String getMessage() {
        return message;
    }

    public User getUser() {
        return user;
    }
}
