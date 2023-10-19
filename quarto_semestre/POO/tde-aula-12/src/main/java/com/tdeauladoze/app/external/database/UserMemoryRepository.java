package com.tdeauladoze.app.external.database;

import com.tdeauladoze.app.rules.user.model.User;
import com.tdeauladoze.app.rules.user.service.IUserRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.UUID;

@Service
public class UserMemoryRepository implements IUserRepository {
    private ArrayList<User> users = new ArrayList<>();

    @Override
    public void save(User user) {
        this.users.add(user);
    }

    @Override
    public ArrayList<User> findAll() {
        return this.users;
    }

    @Override
    public ArrayList<User> findById(String id) {
        ArrayList<User> users = new ArrayList<>();
        UUID uuid = UUID.fromString(id);

        for(User user: this.users) {
            if (user.getId().getValue().equals(uuid)) {
                users.add(user);
            }
        }
        return users;
    }
}
