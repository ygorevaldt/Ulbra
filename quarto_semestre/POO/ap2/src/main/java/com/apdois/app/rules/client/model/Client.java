package com.apdois.app.rules.client.model;

import com.apdois.app.rules.shared.Entity;
import com.apdois.app.rules.shared.objectvalues.Birthday;
import com.apdois.app.rules.shared.objectvalues.Email;
import com.apdois.app.rules.shared.objectvalues.SimpleName;

public class Client extends Entity {
    private SimpleName name;
    private Email email;
    private Birthday birthday;
    private String profession;

    public Client(SimpleName name, Email email, Birthday birthday, String profession) {
        this.name = name;
        this.email = email;
        this.birthday = birthday;
        this.profession = profession;
    }

    public SimpleName getName() {
        return this.name;
    }

    public Email getEmail() {
        return this.email;
    }

    public Birthday getBirthday() {
        return this.birthday;
    }

    public String getProfession() {
        return this.profession;
    }
}
