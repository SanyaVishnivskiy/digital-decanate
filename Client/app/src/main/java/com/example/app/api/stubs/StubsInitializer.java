package com.example.app.api.stubs;

import com.example.app.api.groups.Models.Group;
import com.example.app.api.schedule.Models.Schedule;
import com.example.app.api.schedule.Models.ScheduleItem;
import com.example.app.api.stubs.groups.GroupsCollection;
import com.example.app.api.stubs.schedule.ScheduleCollection;
import com.example.app.api.stubs.user.UsersCollection;
import com.example.app.api.user.Models.User;
import com.example.app.logic.user.RolesConstants;

import java.util.ArrayList;
import java.util.List;

public class StubsInitializer {
    public static void init() {
        createGroups();
        createUsers();
        createSchedules();
    }

    private static void createSchedules() {
        List<ScheduleItem> items = new ArrayList<>();
        items.add(new ScheduleItem("", "teacher", "English", "1.101", "3", "Mon", 1, "Lecture"));
        items.add(new ScheduleItem("", "Aizava", "Math", "1.201", "1", "Mon", 1, "Practice"));

        Schedule schedule = new Schedule("", "1", items);
        ScheduleCollection.getInstance().addOrUpdate(schedule);
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
        groups.add(new Group("1", "424", new ArrayList<>(), ""));
        groups.add(new Group("2", "119", new ArrayList<>(), ""));

        GroupsCollection.getInstance().init(groups);
    }

}
