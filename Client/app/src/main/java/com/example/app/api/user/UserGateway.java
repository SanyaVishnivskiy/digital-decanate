package com.example.app.api.user;

import android.os.AsyncTask;

import com.example.app.api.ApiAsyncTask;
import com.example.app.api.Http;
import com.example.app.api.IAsyncRequest;
import com.google.gson.Gson;

import java.util.concurrent.ExecutionException;

public class UserGateway implements IUserGateway {
    private Http http = new Http();
    private Gson gson = new Gson();

    private String baseurl = "user";

    public User getCurrentUser() throws ExecutionException, InterruptedException {
        AsyncTask<String, Void, String> result = new ApiAsyncTask(new GetCurrentUserRequest())
                .execute();
        String output = result.get();
        return gson.fromJson(output, User.class);
    }

    private class GetCurrentUserRequest implements IAsyncRequest {
        @Override
        public String sendRequest() {
            return http.GET(baseurl + "/1");
        }

        @Override
        public String handleResponse(String output) { return output; }
    }
}
