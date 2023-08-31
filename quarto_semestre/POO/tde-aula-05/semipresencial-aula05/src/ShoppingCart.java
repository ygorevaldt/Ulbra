import java.util.ArrayList;

public class ShoppingCart {
    private ArrayList<Product> products = new ArrayList<>();

    public void add(Product product) {
        this.products.add(product);
    }

    public ArrayList<Product> getProducts() {
        return products;
    }

    public double getTotal() {
        double total = 0.0;
        for (Product product: this.products) {
            total += product.getValue();
        }

        return total;
    }
}
