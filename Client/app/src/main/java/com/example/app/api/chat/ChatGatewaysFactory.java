package com.example.app.api.chat;

import com.example.app.api.stubs.chats.ChatListGatwayStub;
import com.example.app.api.stubs.chats.GlobalChatGatewayStub;
import com.example.app.api.stubs.chats.PersonalChatGatewayStub;

public class ChatGatewaysFactory {
    public IGlobalChatGateway createGlobalChatGateway(){
        return new GlobalChatGatewayStub();
    }

    public IPersonalChatGateway createPersonalChatGateway(){
        return new PersonalChatGatewayStub();
    }

    public IChatListGateway createChatListGateway(){
        return new ChatListGatwayStub();
    }
}
