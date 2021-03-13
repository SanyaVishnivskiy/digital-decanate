package com.example.app.api.groups;

import com.example.app.api.stubs.groups.GroupsGateway;

public class GroupGatewayFactory {
    public IGroupsGateway createGroupListGateway(){
        return new GroupsGateway();
    }
}
