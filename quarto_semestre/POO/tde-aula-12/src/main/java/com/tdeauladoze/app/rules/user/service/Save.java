package com.tdeauladoze.app.rules.user.service;

import com.tdeauladoze.app.rules.shared.IUseCase;
import com.tdeauladoze.app.rules.user.model.User;

public class Save implements IUseCase<User, Void> {
    private IUserRepository repository;

    public Save(IUserRepository repository) {
        this.repository = repository;
    }

    @Override
    public Void execute(User user) {
        this.repository.save(user);
        return null;
    }
}
