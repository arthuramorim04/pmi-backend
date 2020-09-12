package com.arthuramorim.apispring.manager;

import com.arthuramorim.apispring.entity.User;

import javax.annotation.Resource;
import java.util.HashSet;

@Resource
public class UserLoginManager {

    private HashSet<User> logged;

    public UserLoginManager(HashSet<User> logged) {
        this.logged = logged;
    }

    public void addUser(User user) {
        if (!logged.contains(user)) {
            logged.add(user);
        }
    }


    public void removeUser(User user) {
        if (logged.contains(user)) {
            logged.remove(user);
        }
    }

    public HashSet<User> getLogged() {
        return logged;
    }
}
