package com.example.app.ui.user;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.example.app.api.auth.AuthGatewayFactory;
import com.example.app.api.auth.IAuthGateway;
import com.example.app.api.groups.GroupGatewayFactory;
import com.example.app.api.groups.IGroupsGateway;
import com.example.app.api.user.IUserGateway;
import com.example.app.api.user.Models.InvalidPasswordException;
import com.example.app.api.user.Models.PasswordNotMatchException;
import com.example.app.api.user.Models.UserWithChangePasswordModel;
import com.example.app.api.user.User;
import com.example.app.api.user.UserGatewayFactory;
import com.example.app.logic.user.UserContext;
import com.example.app.api.groups.Models.Group;

public class UserViewModel extends ViewModel {
    private final IUserGateway _gateway;
    private final IAuthGateway _authGateway;
    private final IGroupsGateway _groupsGateway;
    private MutableLiveData<User> _user;

    public UserViewModel() {
        _gateway = new UserGatewayFactory().create();
        _authGateway = new AuthGatewayFactory().create();
        _groupsGateway = new GroupGatewayFactory().createGroupListGateway();
        _user = new MutableLiveData<>();
    }

    public LiveData<User> getUser() {
        String id = UserContext.getInstance().getCurrentUser().getId();
        User user = _gateway.getById(id);
        user = setGroupName(user);

        _user.setValue(user);
        return _user;
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

    public void save(UserWithChangePasswordModel user) throws PasswordNotMatchException, InvalidPasswordException {
        //TODO: use another user model, groupId here is groupName
        Group group = _groupsGateway.getByName(user.getGroupId());
        user = setGroupId(user, group);

        _gateway.addOrUpdate(user);
        if (user.getChangePasswordModel() != null) {
            _authGateway.changePassword(user.getChangePasswordModel());
        }
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
}