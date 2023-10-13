package com.poo.tde.database;

import com.poo.tde.rules.usuario.model.User;
import com.poo.tde.rules.usuario.service.IUserRepository;

import java.util.ArrayList;

public class UserMemoryRepository implements IUserRepository {
    private ArrayList<User> users = new ArrayList<>();

    @Override
    public void save(User user) {
        this.users.add(user);
    }

    @Override
    public ArrayList<User> searchAll() {
        return this.users;
    }
}
