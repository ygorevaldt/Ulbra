import java.util.UUID;

public class Property implements ISpace {
    private UUID id;
    private String name;
    private boolean isPurchased;
    private double price;
    private double rental;

    public Property(String name, double price, double rental) {
        this.id = UUID.randomUUID();
        this.isPurchased = false;
        this.name = name;
        this.price = price;
        this.rental = rental;
    }

    @Override
    public void action(Player player) {
        if (this.isPurchased) {
            // Verifica se a propriedade é do jogador
            // Caso seja, não faz nada
            // Caso não seja, cobra aluguel
            return;
        }

        // Verifica se jogador tem saldo suficiente para comprar imóvel
        // Caso tenha, oferece propriedade ao jogador
        // Caso não tenha, não faz nada.
    }

    public UUID getId() {
        return this.id;
    }

    public String getName() {
        return name;
    }

    public void vacate() {
        this.isPurchased = false;
    }

    public void buy() {
        this.isPurchased = true;
    }

    public double getRental() {
        return rental;
    }

    @Override
    public String getDescription() {
        return "Propriedade";
    }
}
