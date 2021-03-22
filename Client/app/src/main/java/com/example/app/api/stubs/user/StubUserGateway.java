package com.example.app.api.stubs.user;

import com.example.app.api.groups.Models.Group;
import com.example.app.api.stubs.groups.GroupsCollection;
import com.example.app.api.user.IUserGateway;
import com.example.app.api.user.Models.User;

public class StubUserGateway implements IUserGateway {

    @Override
    public void addOrUpdate(User user) {
        UsersCollection.getInstance().add(user);

        deleteUserFromAllGroups(user);
        addUserToCorrectGroup(user);
    }

    private void deleteUserFromAllGroups(User user) {
        for (Group group : GroupsCollection.getInstance().getAll()) {
            for (User u : group.getUsers()) {
                if (u.equals(user)) {
                    group.getUsers().remove(group);
                }
            }
        }
    }

    private void addUserToCorrectGroup(User user) {
        Group group = GroupsCollection.getInstance().getById(user.getGroupId());
        group.getUsers().add(user);
    }

    @Override
    public User getByToken(String token) {
        return getById(token);
    }

    @Override
    public User getById(String id) {
        return UsersCollection.getInstance().getById(id);
    }
}
