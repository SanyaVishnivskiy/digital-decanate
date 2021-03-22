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

    }

    public void init(List<Group> groups) {
        for(Group group : groups){
            add(group);
        }
    }

    public Group getById(String id) {
        return groups.get(id);
    }

    public void add(Group group) {
        Group existing = GroupsCollection.getInstance().getById(group.getId());
        if(existing == null){
            groups.put(group.getId(), group);
            return;
        }

        groups.put(group.getId(),group);

    }

    public List<Group> getAll(){
        return new ArrayList<Group>(groups.values());
    }

    public Group getByName(String name) {
        for (Group group : groups.values()) {
            if (group.getNumber().equals(name)){
                return group;
            }
        }

        return null;
    }
}
