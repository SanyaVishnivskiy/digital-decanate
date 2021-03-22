package com.example.app.api;

import android.util.Log;

import org.apache.http.HttpEntity;
import org.apache.http.HttpRequest;
import org.apache.http.HttpResponse;
import org.apache.http.HttpStatus;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpDelete;
import org.apache.http.client.methods.HttpEntityEnclosingRequestBase;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.client.methods.HttpPut;
import org.apache.http.client.methods.HttpRequestBase;
import org.apache.http.client.methods.HttpUriRequest;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.util.EntityUtils;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.net.URI;
import java.net.URISyntaxException;

public class Http {
    private final String URL = "https://10.0.2.2:5001/api/";

    public String POST(String url, String body) {
        try {
            return Execute(url, body, "POST");
        } catch (Exception e) {
            //Log.d("Post", e.getMessage());
        }
        return "";
    }

    public String GET(String url) {
        try {
            return Execute(url, "", "GET");
        } catch (Exception e) {
            Log.d("Post", e.getMessage());
        }
        return "";
    }

    private String Execute(String url, String body, String method) throws IOException, URISyntaxException {
        HttpClient httpclient = new DefaultHttpClient();
        HttpRequestBase request = buildRequest(url, method, body);

        HttpResponse resp = httpclient.execute(request);
        if (resp.getStatusLine().getStatusCode() == HttpStatus.SC_OK) {
            HttpEntity ent = resp.getEntity();
            String result = EntityUtils.toString(ent);
            return result;
        }

        return "";
    }

    private HttpRequestBase buildRequest(String url, String method, String body) throws URISyntaxException, UnsupportedEncodingException {
        HttpRequestBase request = createHttpRequestBase(method);

        request.setURI(new URI(URL + url));
        request.setHeader("Accept-Encoding", "gzip,deflate");
        request.setHeader("Content-Type", "application/json");
        request.setHeader("Host", "192.168.42.82");
        request.setHeader("Connection", "Keep-Alive");
        request.setHeader("User-Agent", "Apache-HttpClient/4.1.1");

        setBodyIfNeeded(request, body);

        return request;
    }

    private void setBodyIfNeeded(HttpRequestBase request, String body) throws UnsupportedEncodingException {
        if (request instanceof HttpGet || request instanceof HttpDelete) {
            return;
        }

        HttpEntityEnclosingRequestBase requestWithBody = (HttpEntityEnclosingRequestBase)request;
        StringEntity content = new StringEntity(body);
        requestWithBody.setEntity(content);
    }

    private HttpRequestBase createHttpRequestBase(String method) {
        switch (method) {
            case "POST":
                return new HttpPost();
            case "GET":
                return new HttpGet();
            case "PUT":
                return new HttpPut();
            case "DELETE":
                return new HttpDelete();
            default:
                return null;
        }
    }
}
