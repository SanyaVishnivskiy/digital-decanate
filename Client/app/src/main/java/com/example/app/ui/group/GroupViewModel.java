package com.example.app.ui.group;

import com.example.app.api.groups.GroupGatewayFactory;
import com.example.app.api.groups.IGroupsGateway;
import com.example.app.api.groups.Models.Group;
import com.example.app.api.stubs.groups.GroupsCollection;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import androidx.lifecycle.ViewModel;

public class GroupViewModel extends ViewModel {
    final IGroupsGateway _gateway;

    public GroupViewModel(){
        _gateway = new GroupGatewayFactory().createGroupListGateway();
    }

    public void save(GroupWithViews group){
        _gateway.addOrUpdate(convertGroup(group));
    }

    public Group convertGroup(GroupWithViews groupWithViews){
        List<Group> groups = GroupsCollection.getInstance().getAll();
        for(Group g : groups){
            if(g.getNumber().equals(groupWithViews.getNumber())){
                return new Group(
                        String.valueOf(g.getId()),
                        groupWithViews.getNumber(),
                        groupWithViews.getUsers(),
                        groupWithViews.getHeadid(),
                        groupWithViews.getFaculty());
            }
        }
        return new Group(
                String.valueOf(groups.size()+1),
                groupWithViews.getNumber(),
                groupWithViews.getUsers(),
                groupWithViews.getHeadid(),
                groupWithViews.getFaculty());
    }
}
