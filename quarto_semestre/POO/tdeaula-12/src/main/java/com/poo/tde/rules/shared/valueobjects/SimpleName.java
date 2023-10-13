package rules.shared.valueobjects;

import java.text.Normalizer;

public class SimpleName {
    private String complete;
    private int min = 3;
    private int max = 150;

    public SimpleName(String complete) {
        if (complete == null || complete.trim().isEmpty()) {
            throw new IllegalArgumentException("Nome é obrigatório");
        }
        if (complete.length() < min) {
            throw new IllegalArgumentException(String.format("Nome deve ter no mínimo %d caracteries", this.min));
        }
        if (complete.length() > max) {
            throw new IllegalArgumentException(String.format("Nome deve ter no máximo %d caracteries", this.max));
        }
        if (this.hasSpecialCharacters(complete)) {
            throw new IllegalArgumentException("Nome não pode conter caractéries especiais");
        }

        this.complete = complete;
    }

    private boolean hasSpecialCharacters(String text) {
        String normalizedText = Normalizer.normalize(text, Normalizer.Form.NFD).replaceAll("[\\p{InCombiningDiacriticalMarks}]", "");
        return normalizedText.matches(".*[^a-zA-ZÀ-ú\\s].*");
    }

    public String complete() {
        return this.complete;
    }

    public String partial(int numberOfCharacters) {
        return complete.substring(0, numberOfCharacters);
    }
}
