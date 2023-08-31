public class Product {
    private String name;
    private double value = 0.0;
    private String description;

    public Product(String name, double value) {
        this.name = name;
        this.value = value;
    }

    public double getValue() {
        return value;
    }

    @Override
    public String toString() {
        return this.name + " R$" + this.value;
    }
}
