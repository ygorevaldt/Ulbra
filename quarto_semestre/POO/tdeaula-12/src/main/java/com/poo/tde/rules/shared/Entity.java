package com.poo.tde.rules.shared;

import com.poo.tde.rules.shared.valueobjects.Id;

public class Entity {
    protected Id id;
    public Entity() {
        id = new Id();
    }

    public boolean equals(Entity entity) {
        return this.id.getValue() == entity.id.getValue();
    }

    public boolean different(Entity entity) {
        return this.equals(entity);
    }
}
