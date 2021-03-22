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
import com.example.app.api.user.Models.User;
import com.example.app.api.user.UserGatewayFactory;
import com.example.app.logic.user.IUserComponent;
import com.example.app.logic.user.UserComponent;
import com.example.app.logic.user.UserContext;
import com.example.app.api.groups.Models.Group;

public class UserViewModel extends ViewModel {
    private final IUserComponent _component;
    private MutableLiveData<User> _user;

    public UserViewModel() {
        _component = new UserComponent();
        _user = new MutableLiveData<>();
    }

    public LiveData<User> getUser() {
        User user = _component.getCurrentUser();

        _user.setValue(user);
        return _user;
    }

    public void save(UserWithChangePasswordModel user) throws PasswordNotMatchException, InvalidPasswordException {
        _component.save(user);
    }
}