package com.example.app.api.marks.Models;

import java.util.Date;

public class MarksItem {
    private String id;
    private String userId;
    private String subject;
    private String mark;
    private Date date;

    public MarksItem(String id, String userId, String subject, String mark, Date date) {
        this.id = id;
        this.userId = userId;
        this.subject = subject;
        this.mark = mark;
        this.date = date;
    }

    public String getId() {
        return id;
    }

    public String getUserId() {
        return userId;
    }

    public String getSubject() {
        return subject;
    }

    public String getMark() {
        return mark;
    }

    public Date getDate() {
        return date;
    }
}
