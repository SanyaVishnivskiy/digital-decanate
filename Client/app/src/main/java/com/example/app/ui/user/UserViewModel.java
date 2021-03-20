package com.example.app.ui.user;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.example.app.api.user.IUserGateway;
import com.example.app.api.user.Models.User;
import com.example.app.api.user.UserGatewayFactory;

public class UserViewModel extends ViewModel {
    private final IUserGateway _gateway;
    private MutableLiveData<User> _user;

    public UserViewModel() {
        _gateway = new UserGatewayFactory().create();
        _user = new MutableLiveData<>();
    }

    public LiveData<User> getUser() {
        User user = _gateway.getById("1");
        _user.setValue(user);
        return _user;
    }
}