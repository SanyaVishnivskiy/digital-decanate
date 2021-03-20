package com.example.app.api.stubs.user;

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
        Init();
    }

    private void Init(){
        users.put("1", new User("1", "name", "lastname", "1564", "a@m.c", "456", "1", "F", 1, "Admin"));
        users.put("2", new User("2", "name", "lastname", "1564", "u@m.c", "456", "1", "F", 1, "User"));
    }

    public User getById(String id) {
        return users.get(id);
    }

    public void Add(User user) {
        users.put(user.getId(), user);
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
    public  List<User> getAll(){
        return new ArrayList<User>(users.values());
    }
}
