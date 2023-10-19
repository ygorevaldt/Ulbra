package com.poo.tde.rules.usuario.service;

import com.poo.tde.rules.shared.IUseCase;
import com.poo.tde.rules.usuario.model.User;

import java.util.ArrayList;

public class ConsultUser implements IUseCase<Void, ArrayList<User>> {

    private IUserRepository repository;

    public ConsultUser(IUserRepository repository) {
        this.repository = repository;
    }

    @Override
    public ArrayList<User> execute(Void input) {
        return this.repository.searchAll();
    }
}
