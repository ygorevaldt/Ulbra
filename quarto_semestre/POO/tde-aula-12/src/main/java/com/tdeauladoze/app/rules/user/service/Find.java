package com.tdeauladoze.app.rules.user.service;

import com.tdeauladoze.app.rules.shared.IUseCase;
import com.tdeauladoze.app.rules.user.model.User;

import java.util.ArrayList;

public class Find implements IUseCase<String, ArrayList<User>> {
    private IUserRepository repository;
    public Find(IUserRepository repository) {
        this.repository = repository;
    }

    public ArrayList<User> execute() {
        return this.repository.findAll();
    }

    public ArrayList<User> execute(String id) {
        return this.repository.findById(id);
    }
}
