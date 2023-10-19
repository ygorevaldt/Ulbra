package com.tdeauladoze.app.rules.user.service;

import com.tdeauladoze.app.rules.user.model.User;

import java.util.ArrayList;

public interface IUserRepository {
    void save(User user);
    ArrayList<User> findAll();
    ArrayList<User> findById(String id);
}
