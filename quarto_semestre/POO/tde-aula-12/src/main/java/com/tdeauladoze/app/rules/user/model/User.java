package com.tdeauladoze.app.rules.user.model;

import com.tdeauladoze.app.rules.shared.Entity;
import com.tdeauladoze.app.rules.shared.objectvalues.Email;
import com.tdeauladoze.app.rules.shared.objectvalues.SimpleName;

public class User extends Entity {
    private SimpleName name;
    private Email email;

    public User(SimpleName name, Email email) {
        this.name = name;
        this.email = email;
    }

    public SimpleName getName() {
        return this.name;
    }

    public Email getEmail() {
        return this.email;
    }
}
