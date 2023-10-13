package rules.usuario.model;

import rules.shared.Entity;
import rules.shared.valueobjects.Cellphone;
import rules.shared.valueobjects.SimpleName;

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
