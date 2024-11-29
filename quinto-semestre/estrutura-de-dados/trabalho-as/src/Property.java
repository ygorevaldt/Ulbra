import java.util.Scanner;
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
        Scanner scanner = new Scanner(System.in);

        if (this.isPurchased) {
            Property playerProperty = player.getProperty(this.id);
            if (playerProperty != null)
                return;

            player.setBankBalance(player.getBankBalance() - this.rental);
            System.out.println(String.format("VOCÊ PRECISOU PAGAR %.2f DE ALUGUEL", this.rental));
            System.out.println(String.format("SALDO BANCARIO ATUAL: %.2f", player.getBankBalance()));
            return;
        }

        String playerResponse;
        do {
            System.out.println(String.format("SEU SALDO BANCÁRIO É R$%.2f", player.getBankBalance()));
            System.out.println(String.format("COMPRAR %s POR R$%.2f?", this.name, this.price));
            System.out.println("[S/N]?");
            playerResponse = scanner.nextLine();

        } while (!playerResponse.equalsIgnoreCase("N") && !playerResponse.equalsIgnoreCase("S"));

        if (playerResponse.equalsIgnoreCase("N"))
            return;

        if (this.price > player.getBankBalance()) {
            System.out.println("SALDO INSUFICIENTE PARA REALIZAR A COMPRA DO IMÓVEL");
            return;
        }

        player.setBankBalance(player.getBankBalance() - this.price);
        this.isPurchased = true;
        System.out.println("PARABÉNS PELA COMPRA DO IMÓVEL " + this.name);
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

    public double getPrice() {
        return this.price;
    }

    @Override
    public String getDescription() {
        return "Propriedade";
    }
}
