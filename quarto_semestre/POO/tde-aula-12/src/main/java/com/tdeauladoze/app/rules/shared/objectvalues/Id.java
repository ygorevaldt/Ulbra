package com.tdeauladoze.app.rules.shared.objectvalues;

import java.util.UUID;

public class Id {
    private UUID value;

    public Id() {
        this.value = UUID.randomUUID();
    }

    public UUID getValue() {
        return this.value;
    }
}
