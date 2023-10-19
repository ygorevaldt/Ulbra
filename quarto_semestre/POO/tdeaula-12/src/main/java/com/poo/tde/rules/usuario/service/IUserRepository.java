package com.poo.tde.rules.usuario.service;

import com.poo.tde.rules.usuario.model.User;

import java.util.ArrayList;

public interface IUserRepository {
    void save(User user);
    ArrayList<User> searchAll();
}
