public abstract class Product {
    int Code;
    double Price;

    public abstract void showDetails();
}

class PerishableProduct extends Product {
    String Validity;

    public PerishableProduct(int code, double price, String validity) {
        this.Code = code;
        this.Price = price;
        this.Validity = validity;
    }

    @Override
    public void showDetails() {
        System.out.println("Código: " + this.Code + " R$" + this.Price + " Validade: " + this.Validity);
    }
}
