public class Store {
    private Product product01;
    private Product product02;
    private Product product03;

    public void addProduct(Product product) {
        String sucessMessage = "Produto " + product.getName() + " adicionado.";
        String failMessage = "O produto " + product.getName() + "não pode ser adicionado, estoque cheio";

        if (this.product01 == null) {
            this.product01 = product;
            System.out.println(sucessMessage);
        }
        else if (this.product02 == null) {
            this.product02 = product;
            System.out.println(sucessMessage);
        }
        else if (this.product03 == null) {
            this.product03 = product;
            System.out.println(sucessMessage);
        } else {
            System.out.println(failMessage);
        }
    }

    public void removeProduct(Product product) {
        String sucessMessage = "Produto " + product.getName() + " removido da loja.";
        String failMessage = "Produto " + product.getName() + "não encontrado no estoque";

        if (this.product01 == product) {
            this.product01 = null;
            System.out.println(sucessMessage);
        }
        else if (this.product02 == product) {
            this.product02 = null;
            System.out.println(sucessMessage);
        }
        else if (this.product03 == product) {
            this.product03 = null;
            System.out.println(sucessMessage);
        } else {
            System.out.println(failMessage);
        }


    }

    public void listProducts() {
        if (this.product01 != null) {
            System.out.println("Produto: " + this.product01.getName() + " Quantidade: " + this.product01.getAmount());
        }
        if (this.product02 != null) {
            System.out.println("Produto: " + this.product02.getName() + " Quantidade: " + this.product02.getAmount());
        }
        if (this.product03 != null) {
            System.out.println("Produto: " + this.product03.getName() + " Quantidade: " + this.product03.getAmount());
        }
    }

    public void sellProduct(Product product, int amount) {
        int stock;
        int newStock;
        String successMessage = "Venda realizada com sucesso";
        String failMessage = "Estoque insuficiente";

        if (this.product01 == product) {
            stock = this.product01.getAmount();
            if (stock >= amount) {
                newStock = stock - amount;
                this.product01.setAmount(newStock);
                System.out.println(successMessage);
            } else {
                System.out.println(failMessage);
            }
        }
        else if (this.product02 == product) {
            stock = this.product02.getAmount();
            if (stock >= amount) {
                newStock = stock - amount;
                this.product02.setAmount(newStock);
                System.out.println(successMessage);
            } else {
                System.out.println(failMessage);
            }
        }
        else if (this.product03 == product) {
            stock = this.product03.getAmount();
            if (stock >= amount) {
                newStock = stock - amount;
                this.product03.setAmount(newStock);
                System.out.println(successMessage);
            } else {
                System.out.println(failMessage);
            }
        }
    }

    public void addStock(Product product, int amount) {
        int stock;
        int newStock;
        String successMessage = "Nova quantidade do produto " + product.getName() + " adicionada com sucesso.";

        if (this.product01 == product) {
            stock = this.product01.getAmount();
            newStock = stock + amount;
            this.product01.setAmount(newStock);
            System.out.println(successMessage);
        }
        else if (this.product02 == product) {
            stock = this.product02.getAmount();
            newStock = stock + amount;
            this.product02.setAmount(newStock);
            System.out.println(successMessage);
        }
        else if (this.product03 == product) {
            stock = this.product03.getAmount();
            newStock = stock + amount;
            this.product03.setAmount(newStock);
            System.out.println(successMessage);
        }
    }

}
