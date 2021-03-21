package com.example.app.ui.createUser;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

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
import com.example.app.logic.user.IUserComponent;
import com.example.app.logic.user.UserComponent;
import com.example.app.logic.user.UserContext;

import static java.util.UUID.randomUUID;

public class CreateUserViewModel extends ViewModel {
    private final IUserComponent _component;
    private MutableLiveData<User> _user;

    public CreateUserViewModel() {
        _user = new MutableLiveData<>();
        _component = new UserComponent();
    }

    public void save(UserWithPassword user) throws PasswordNotMatchException, InvalidPasswordException {
        if (user.getId() == null || user.getId().equals(""))
        {
            user = fillId(user);
        }

        _component.save(user);
    }

    private UserWithPassword fillId(UserWithPassword user) {
        return new UserWithPassword(
            randomUUID().toString(),
            user.getName(),
            user.getLastName(),
            user.getPhoneNumber(),
            user.getEmail(),
            user.getStudentTicket(),
            user.getGroupId(),
            user.getFaculty(),
            user.getCourse(),
            user.getRole(),
            user.getPassword()
        );
    }
}