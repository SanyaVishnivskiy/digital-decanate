package com.example.app.api;

import android.content.Context;
import android.os.AsyncTask;

public class ApiAsyncTask extends AsyncTask<String, Void, String> {

    private final IAsyncRequest request;

    public ApiAsyncTask(IAsyncRequest request) {
        this.request = request;
    }

    @Override
    protected String doInBackground(String... strings) {
        return request.sendRequest();
    }

    @Override
    protected void onPostExecute(String result) {
        request.handleResponse(result);
    }
}
