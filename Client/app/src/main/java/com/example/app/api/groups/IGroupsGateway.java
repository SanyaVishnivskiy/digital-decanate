package com.example.app.api.groups;

import java.util.List;

import com.example.app.api.groups.Models.Group;

public interface IGroupsGateway {
    void addOrUpdate(Group group);
    Group getById(String id);
    Group getByName(String name);
}
