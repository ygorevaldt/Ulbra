package com.poo.tde.rules.usuario.model;

import com.poo.tde.rules.shared.Entity;
import com.poo.tde.rules.shared.valueobjects.Cellphone;
import com.poo.tde.rules.shared.valueobjects.SimpleName;

public class User extends Entity {
    private SimpleName name;
    private Cellphone phoneNumber;

    public User(String name, String phoneNumber) {
        this.name = new SimpleName(name);
        this.phoneNumber = new Cellphone(phoneNumber);
    }

    public SimpleName name() {
        return this.name;
    }

    public Cellphone phoneNumber() {
        return this.phoneNumber;
    }
}
