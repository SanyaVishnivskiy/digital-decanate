package com.example.app.ui.user;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.example.app.api.user.IUserGateway;
import com.example.app.api.user.StubUserGateway;
import com.example.app.api.user.User;
import com.example.app.api.user.UserGateway;

import java.util.concurrent.ExecutionException;

public class UserViewModel extends ViewModel {
    private final IUserGateway _gateway;
    private MutableLiveData<User> _user;

    public UserViewModel() {
        _gateway = new StubUserGateway();
        _user = new MutableLiveData<>();
    }

    public LiveData<User> getUser() throws ExecutionException, InterruptedException {
        User user = _gateway.getCurrentUser();
        _user.setValue(user);
        return _user;
    }
}