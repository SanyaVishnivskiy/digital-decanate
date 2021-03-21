package com.example.app.api.user.Models;

import java.util.Objects;

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

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getLastName() {
        return lastName;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public String getEmail() {
        return email;
    }

    public String getStudentTicket() {
        return studentTicket;
    }

    public String getGroupId() {
        return groupId;
    }

    public String getFaculty() {
        return faculty;
    }

    public int getCourse() {
        return course;
    }

    public String getRole() {
        return role;
    }

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

    public User(User user) {
        this.id = user.getId();
        this.name = user.getName();
        this.lastName = user.getLastName();
        this.phoneNumber = user.getPhoneNumber();
        this.email = user.getEmail();
        this.studentTicket = user.getStudentTicket();
        this.groupId = user.getGroupId();
        this.faculty = user.getFaculty();
        this.course = user.getCourse();
        this.role = user.getRole();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        User user = (User) o;
        return course == user.course &&
                Objects.equals(id, user.id) &&
                Objects.equals(name, user.name) &&
                Objects.equals(lastName, user.lastName) &&
                Objects.equals(phoneNumber, user.phoneNumber) &&
                Objects.equals(email, user.email) &&
                Objects.equals(studentTicket, user.studentTicket) &&
                Objects.equals(groupId, user.groupId) &&
                Objects.equals(faculty, user.faculty) &&
                Objects.equals(role, user.role);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, lastName, phoneNumber, email, studentTicket, groupId, faculty, course, role);
    }
}
