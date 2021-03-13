package com.example.app.api.groups;

import java.util.List;

import androidx.constraintlayout.widget.Group;

public interface IGroupsGateway {
    void addOrUpdate(Group group);
    Group getById(String id);
}
