package com.poo.tde.external.database;

import com.poo.tde.rules.usuario.model.User;
import com.poo.tde.rules.usuario.service.IUserRepository;
import org.springframework.lang.Nullable;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.ArrayList;

@Service
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
