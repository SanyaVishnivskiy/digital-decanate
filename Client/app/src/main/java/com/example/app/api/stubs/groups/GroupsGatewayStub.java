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
        return GroupsCollection.getInstance().getById(id);
    }

    @Override
    public Group getByName(String name) {
        return GroupsCollection.getInstance().getByName(name);
    }

}
