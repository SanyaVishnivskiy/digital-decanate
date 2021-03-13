package com.example.app.api.user;

public class User {
    private String id;
    private String name;
    private String lastName;
    private String phoneNumber;
    private String email;
    private String studentTicket;
    private String groupId;
    private String faculty;
    private int course;

    private String role;

    public User(String id, String name, String lastName, String phoneNumber, String email, String studentTicket, String groupId, String faculty, int course, String role) {
        this.id = id;
        this.name = name;
        this.lastName = lastName;
        this.phoneNumber = phoneNumber;
        this.email = email;
        this.studentTicket = studentTicket;
        this.groupId = groupId;
        this.faculty = faculty;
        this.course = course;
        this.role = role;
    }


    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getLastName() {
        return lastName;
    }

    public String getRole() {
        return role;
    }

}
