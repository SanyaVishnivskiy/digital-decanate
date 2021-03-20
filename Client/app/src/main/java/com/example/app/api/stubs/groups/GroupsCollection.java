package com.example.app.api.stubs.groups;

import com.example.app.api.groups.Models.Group;
import com.example.app.api.stubs.user.UsersCollection;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class GroupsCollection {
    private HashMap<String, Group> groups = new HashMap<>();

    private static GroupsCollection instance = new GroupsCollection();

    public static GroupsCollection getInstance() {
        return instance;
    }

    private GroupsCollection() {
        Init();
    }

    private void Init(){
       groups.put("1",new Group("1","424",UsersCollection.getInstance().getAll(),"1"));
    }

    public Group getById(String id) {
        return groups.get(id);
    }

    public void Add(Group group) {
        groups.put(group.getId(), group);
    }

    public List<Group> getAll(){
        return new ArrayList<Group>(groups.values());
    }
}
