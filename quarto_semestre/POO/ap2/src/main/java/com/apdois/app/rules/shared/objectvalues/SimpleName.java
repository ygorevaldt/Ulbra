package com.apdois.app.rules.shared.objectvalues;

import com.apdois.app.rules.shared.utils.CheckIfSpecialCharacteries;

public class SimpleName {
    private String complete;
    int min = 2;
    int max = 254;


    public SimpleName(String complete) {
        if (this.min > this.max) {
            throw new IllegalArgumentException("Tamanho mínimo não pode ser maior que o maximo");
        }
        if (complete.length() < this.min) {
            throw new IllegalArgumentException(String.format("Nome deve ter no mínimo %d caracteries", this.min));
        }
        if (complete.length() > this.max) {
            throw new IllegalArgumentException(String.format("Nome deve ter no máximo %d caracteries", this.max));
        }

        boolean hasSpecialCharacters = CheckIfSpecialCharacteries.execute(complete);
        if (hasSpecialCharacters) {
            throw new Error("Nome não pode conter caracteries especais");
        }

        this.complete = complete;
    }

    public String getComplete() {
        return this.complete;
    }

    public String getFirstName() {
        String[] sparks = this.complete.split(" ");
        if (sparks.length > 0) {
            return sparks[0];
        }
        return "";
    }

    public String getLastName() {
        String[] sparks = this.complete.split(" ");
        if (sparks.length > 0) {
            return sparks[sparks.length - 1];
        }
        return "";
    }
}
