package com.example.app.api.stubs.groups;

import com.example.app.api.groups.IGroupsGateway;
import com.example.app.api.groups.Models.Group;

import java.util.ArrayList;

public class GroupsGatewayStub implements IGroupsGateway {


    @Override
    public void addOrUpdate(Group group) {

    }

    @Override
    public Group getById(String id) {
        return new Group(id, "424", new ArrayList<>(), "1");
    }

    @Override
    public Group getByName(String name) {
        return new Group("1", name, new ArrayList<>(), "1");
    }

}
