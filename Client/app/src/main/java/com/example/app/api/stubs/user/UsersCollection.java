package com.example.app.api.stubs.user;

import android.os.Build;

import androidx.annotation.RequiresApi;

import com.example.app.api.user.Models.UserWithChangePasswordModel;
import com.example.app.api.user.Models.UserWithPassword;
import com.example.app.api.user.Models.User;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Set;

public class UsersCollection {
    private HashMap<String, User> users = new HashMap<>();

    private static UsersCollection instance = new UsersCollection();

    public static UsersCollection getInstance() {
        return instance;
    }

    private UsersCollection() {

    }

    public void init(List<User> users){
        for (User user: users) {
            add(user);
        }
    }

    public User getById(String id) {
        return users.get(id);
    }

    public void add(User user) {
        User existing = getById(user.getId());
        if (existing == null) {
            users.put(user.getId(), user);
        }

        User toSave = new User(user);
        if (existing instanceof UserWithPassword) {
            toSave = new UserWithPassword(
                user,
                ((UserWithPassword)existing).getPassword());
        }
        users.put(toSave.getId(), toSave);
    }

    public User getByEmail(String email) {
        Set<String> keys = users.keySet();

        for (String key : keys) {
            User user = users.get(key);
            if (user.getEmail().equals(email))
                return user;
        }

        return null;
    }

    @RequiresApi(api = Build.VERSION_CODES.N)
    public void update(User user) {
        users.replace(user.getId(), user);
    }

    public  List<User> getAll(){
        return new ArrayList<User>(users.values());
    }
}
