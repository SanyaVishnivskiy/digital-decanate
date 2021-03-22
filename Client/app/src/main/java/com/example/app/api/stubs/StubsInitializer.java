package com.example.app.api.stubs;

import com.example.app.api.groups.Models.Group;
import com.example.app.api.stubs.groups.GroupsCollection;
import com.example.app.api.stubs.user.UsersCollection;
import com.example.app.api.user.Models.User;
import com.example.app.logic.user.RolesConstants;

import java.util.ArrayList;
import java.util.List;

public class StubsInitializer {
    public static void init() {
        createGroups();
        createUsers();
    }

    private static void createUsers() {
        List<User> users = new ArrayList<>();
        users.add(new User("1", "admin", "admin", "1564", "a@m.c", "456", "1", "F", 1, RolesConstants.Admin));
        users.add(new User("2", "user", "user", "1564", "u@m.c", "456", "1", "F", 1, RolesConstants.User));
        users.add(new User("3", "head", "head", "1564", "h@m.c", "456", "2", "F", 1, RolesConstants.Head));

        UsersCollection.getInstance().init(users);

        Group group = GroupsCollection.getInstance().getById("1");
        group.getUsers().addAll(users.subList(0, 1));

        Group group2 = GroupsCollection.getInstance().getById("2");
        group2.getUsers().addAll(users.subList(2, 2));
    }

    private static void createGroups(){
        ArrayList<Group> groups = new ArrayList<>();
        groups.add(new Group("1", "424", new ArrayList<>(), "","F"));
        groups.add(new Group("2", "119", new ArrayList<>(), "","F"));

        GroupsCollection.getInstance().init(groups);
    }

    private static void createMarks(){

    }

}
