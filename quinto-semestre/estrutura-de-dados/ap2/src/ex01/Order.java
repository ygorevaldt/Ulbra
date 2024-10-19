package ex01;

import java.util.UUID;

public class Order {
    private UUID id;
    private String description;

    public Order(String description) throws Exception {
        this.id = UUID.randomUUID();

        if (description.length() > 100) {
            throw new Exception("The description should have 100 caracteres in max");
        }

        this.description = description;
    }

    public UUID getId() {
        return id;
    }

    public String getDescription() {
        return description;
    }

    @Override
    public String toString() {
        return String.format("{ id: %s, description: %s }\n", this.id, this.description);
    }
}
