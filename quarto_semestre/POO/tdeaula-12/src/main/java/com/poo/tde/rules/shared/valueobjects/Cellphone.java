package rules.shared.valueobjects;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Cellphone {
    private String complete;
    private String regex = "[\\s\\-()]";
    private String validFormat = "\\\\(\\\\d{2}\\\\)\\\\s?9?\\\\d{4}-\\\\d{4}";

    public Cellphone(String complete) {
        if (complete == null || complete.trim().isEmpty()) {
            throw new IllegalArgumentException("Telefone é obrigatório");
        }

        String cleanedNumber = complete.replaceAll(this.regex, "");
        if (!cleanedNumber.matches("[0-9]+]")) {
            throw new IllegalArgumentException(("Número de celular deve conter apenas dígitos de 0 a 9"));
        }
        if (!Pattern.matches(this.validFormat, cleanedNumber)) {
            throw new IllegalArgumentException("Número de celular não está no formato válido");
        }

        this.complete = complete;
    }

    String complete() {
        return this.complete;
    }

    String number() {
        Pattern pattern = Pattern.compile("\\d{2}\\)\\s?(9?\\d{4}-\\d{4})");
        Matcher matcher = pattern.matcher(this.complete);
        if (matcher.find()) {
            return matcher.group(1);
        }
        return null;
    }

    String ddd() {
        Pattern pattern = Pattern.compile("\\((\\d{2})\\)");
        Matcher matcher = pattern.matcher(this.complete);
        if (matcher.find()) {
            return matcher.group(1);
        }
        return null;
    }
}
