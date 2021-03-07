package com.example.app.api;

public interface IAsyncRequest {
    String sendRequest();
    String handleResponse(String output);
}

