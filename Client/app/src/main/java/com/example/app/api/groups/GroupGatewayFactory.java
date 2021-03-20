package com.example.app.api.groups;

import com.example.app.api.stubs.groups.GroupsGatewayStub;

public class GroupGatewayFactory {
    public IGroupsGateway createGroupListGateway(){
        return new GroupsGatewayStub();
    }
}
