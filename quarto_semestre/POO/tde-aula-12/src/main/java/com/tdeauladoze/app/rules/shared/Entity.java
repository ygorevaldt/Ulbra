package com.tdeauladoze.app.rules.shared;

import com.tdeauladoze.app.rules.shared.objectvalues.Id;

public class Entity {
    private Id id;

    public Entity() {
        this.id = new Id();
    }

    public Id getId() {
        return this.id;
    }
}
