package com.tdeauladoze.app.rules.shared.objectvalues;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Email {
    private String value;

    public Email(String value) {
        if (!this.validateEmail(value)) {
            throw new IllegalArgumentException("O E-mail deve ser válido");
        }
        this.value = value;
    }

    private boolean validateEmail(String value) {
        String regex = "^[A-Za-z0-9+_.-]+@(.+)$";
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(value);
        return matcher.matches();
    }

    public String getValue() {
        return this.value;
    }

    public String getProvider() {
        int atIndex = this.value.indexOf('@');
        if (atIndex != -1) {
            return this.value.substring(atIndex + 1, this.value.indexOf('.'));
        }
        return "";
    }
}
