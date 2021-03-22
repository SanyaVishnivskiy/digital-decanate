package com.example.app.ui.group;

import com.example.app.api.user.Models.User;

import java.util.List;

public class GroupWithViews {
    private String number;
    private List<User> users;
    private String headid;
    private String faculty;

    public List<User> getUsers() {
        return users;
    }

    public String getHeadid() {
        return headid;
    }

    public String getNumber() {
        return number;
    }

    public String getFaculty(){ return faculty; }

    public void setNumber(String number){
        this.number = number;
    }

    public void setUsers(List<User> users){
        this.users = users;
    }

    public void setHeadid(String headid){
        this.headid = headid;
    }
    public void setFaculty(String faculty){
        this.faculty = faculty;
    }
}
