package com.tdeauladoze.app.rules.shared.utils;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class CheckIfSpecialCharacteries {
    public static boolean execute(String text) {
        String regex = ".*[^a-zA-Z0-9 \\s].*";
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(text);

        return matcher.matches();
    }
}
