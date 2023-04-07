public class Product {
    private String name;
    private double price;
    private int amount;

    public Product (String name, double price, int amount) {
        this.name = name;
        this.price = price;
        this.amount = amount;
    }

    public String getName() {
        return this.name;
    }

    public double getPrice() {
        return this.price;
    }

    public int getAmount() {
        return this.amount;
    }

    public void setName(String name) {
        this.name = name;
        System.out.println("Nome redefinido com sucesso.");
    }

    public void setPrice(double price) {
        this.price = price;
        System.out.println("Preço redefinido com sucesso.");
    }

    public void setAmount(int amount) {
        this.amount = amount;
        System.out.println("Quantidade redefinida com sucesso.");
    }
}
