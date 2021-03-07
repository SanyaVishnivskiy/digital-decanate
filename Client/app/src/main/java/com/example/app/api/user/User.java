package com.example.app.api.user;

public class User {
    private String id;
    private String name;
    private String lastName;

    private String role;

    public User(String id, String name, String lastName, String role) {
        this.id = id;
        this.name = name;
        this.lastName = lastName;
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
