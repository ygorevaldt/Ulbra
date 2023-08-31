public class Main {
    public static void main(String[] args) {
        ShoppingCart shoppingCart = new ShoppingCart();

        Product milk = new Product("Tirol", 5.39);
        Product rice = new Product("Prato Fino", 6.99);
        Product bean = new Product("Caldo Bom", 10.50);

        shoppingCart.add(milk);
        shoppingCart.add(rice);
        shoppingCart.add(bean);

        System.out.println(shoppingCart.getTotal());
        System.out.println(shoppingCart.getProducts());
    }
}