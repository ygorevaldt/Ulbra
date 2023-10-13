package rules.usuario.service;

import rules.usuario.model.User;

import java.util.ArrayList;

public interface IUserRepository {
    void save(User user);
    ArrayList<User> searchAll();
}
