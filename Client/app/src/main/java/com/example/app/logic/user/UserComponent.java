package com.example.app.logic.user;

import com.example.app.api.auth.AuthGatewayFactory;
import com.example.app.api.auth.IAuthGateway;
import com.example.app.api.groups.GroupGatewayFactory;
import com.example.app.api.groups.IGroupsGateway;
import com.example.app.api.groups.Models.Group;
import com.example.app.api.user.IUserGateway;
import com.example.app.api.user.Models.InvalidPasswordException;
import com.example.app.api.user.Models.PasswordNotMatchException;
import com.example.app.api.user.Models.User;
import com.example.app.api.user.Models.UserWithChangePasswordModel;
import com.example.app.api.user.Models.UserWithPassword;
import com.example.app.api.user.UserGatewayFactory;

public class UserComponent implements IUserComponent{
    private final IUserGateway _gateway;
    private final IAuthGateway _authGateway;
    private final IGroupsGateway _groupsGateway;

    public UserComponent() {
        _gateway = new UserGatewayFactory().create();
        _authGateway = new AuthGatewayFactory().create();
        _groupsGateway = new GroupGatewayFactory().createGroupListGateway();
    }

    @Override
    public User getCurrentUser() {

        User existing = UserContext.getInstance().getCurrentUser();
        if (existing == null) {
            return User.empty();
        }

        User user = _gateway.getById(existing.getId());
        user = setGroupName(user);

        return user;
    }

    private User setGroupName(User user) {
        //TODO: remap to new model because it's confusing that groupName will
        // be stored in groupId field
        Group group = _groupsGateway.getById(user.getGroupId());

        return new User(
                user.getId(),
                user.getName(),
                user.getLastName(),
                user.getPhoneNumber(),
                user.getEmail(),
                user.getStudentTicket(),
                group.getNumber(),
                user.getFaculty(),
                user.getCourse(),
                user.getRole()
        );
    }

    public void save(UserWithPassword user) {
        //TODO: use another user model, groupId here is groupName
        Group group = _groupsGateway.getByName(user.getGroupId());
        user = setGroupId(user, group);

        _gateway.addOrUpdate(user);

        refreshUserIfIsCurrentUser(user);
    }

    private void refreshUserIfIsCurrentUser(User user) {
        String userId = UserContext.getInstance().getCurrentUser().getId();
        if (userId.equals(user.getId())) {
            UserContext.getInstance().refreshUser();
        }
    }

    public void save(UserWithChangePasswordModel user) throws PasswordNotMatchException, InvalidPasswordException {
        addOrUpdateUserWithChangePasswordModel(user);
        if (user.getChangePasswordModel() != null) {
            _authGateway.changePassword(user.getChangePasswordModel());
        }

        refreshUserIfIsCurrentUser(user);
    }

    private void addOrUpdateUserWithChangePasswordModel(UserWithChangePasswordModel user) {
        //TODO: use another user model, groupId here is groupName
        Group group = _groupsGateway.getByName(user.getGroupId());
        user = setGroupId(user, group);

        _gateway.addOrUpdate(user);
    }

    private UserWithChangePasswordModel setGroupId(UserWithChangePasswordModel user, Group group) {
        return new UserWithChangePasswordModel(
                user.getId(),
                user.getName(),
                user.getLastName(),
                user.getPhoneNumber(),
                user.getEmail(),
                user.getStudentTicket(),
                group.getId(),
                user.getFaculty(),
                user.getCourse(),
                user.getRole(),
                user.getChangePasswordModel()
        );
    }

    private UserWithPassword setGroupId(UserWithPassword user, Group group) {
        return new UserWithPassword(
                user.getId(),
                user.getName(),
                user.getLastName(),
                user.getPhoneNumber(),
                user.getEmail(),
                user.getStudentTicket(),
                group.getId(),
                user.getFaculty(),
                user.getCourse(),
                user.getRole(),
                user.getPassword()
        );
    }

}
