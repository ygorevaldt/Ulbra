public class Main {
    public static void main(String[] args) {
        Product product01 = new Product("Cerveja", 6.70,10);
        Product product02 = new Product("Chocolate", 7.80,10);
        Product product03 = new Product("Salgadinho", 15.99,10);
        Product product04 = new Product("Areia de gato", 8.79, 10);

        Store store = new Store();
        //Listando produtos
        store.listProducts();

        //Adicionando produtos
        store.addProduct(product01);
        store.addProduct(product02);
        store.addProduct(product03);
        store.addProduct(product04);

        //Listando produtos
        store.listProducts();

        //Removendo produto [Salgadinho]
        store.removeProduct(product03);

        //Listando produtos
        store.listProducts();

        //Vendendo produto [Cerveja]
        store.sellProduct(product01, 5);
        store.sellProduct(product01, 50);

        //Listando produtos
        store.listProducts();

        //Adicionando estoque de cerveja
        store.addStock(product01, 5);

        //Listando produtos
        store.listProducts();


    }
}