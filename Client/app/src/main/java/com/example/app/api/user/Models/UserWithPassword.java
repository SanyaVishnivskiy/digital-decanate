package com.example.app.api.user.Models;

import com.example.app.api.user.User;

public class UserWithPassword extends User {
    private String password;

    public String getPassword() {
        return password;
    }

    public UserWithPassword(String id, String name, String lastName, String phoneNumber, String email, String studentTicket, String groupId, String faculty, int course, String role, String password) {
        super(id, name, lastName, phoneNumber, email, studentTicket, groupId, faculty, course, role);
        this.password = password;
    }

    public UserWithPassword(User user, String password) {
        super(  user.getId(),
                user.getName(),
                user.getLastName(),
                user.getPhoneNumber(),
                user.getEmail(),
                user.getStudentTicket(),
                user.getGroupId(),
                user.getFaculty(),
                user.getCourse(),
                user.getRole());
        this.password = password;
    }
}
