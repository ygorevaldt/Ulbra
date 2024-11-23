import java.util.UUID;

public class Property implements Space {
    private UUID id;

    public Property() {
        this.id = UUID.randomUUID();
    }

    public UUID getId() {
        return this.id;
    }

    @Override
    public void action(Player player) {
        throw new UnsupportedOperationException("Unimplemented method 'action'");
    }
}
