package com.example.app.api.groups.Models;

import com.example.app.api.user.Models.User;

import java.util.List;

public class Group {
    private String id;
    private String number;
    private List<User> users;
    private String faculty;
    private String headid;

    public Group(String id, String number, List<User> users, String headid,String faculty) {
        this.id = id;
        this.number = number;
        this.users = users;
        this.headid = headid;
        this.faculty = faculty;
    }

    public String getFaculty(){ return faculty; }

    public String getId() {
        return id;
    }

    public List<User> getUsers() {
        return users;
    }

    public String getHeadid() {
        return headid;
    }

    public String getNumber() {
        return number;
    }
}
