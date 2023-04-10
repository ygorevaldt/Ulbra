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
        String failMessage = "Produto " + product.getName() + " não encontrado no estoque";

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
            this.printProductData(this.product01);
        }
        if (this.product02 != null) {
            this.printProductData(this.product02);
        }
        if (this.product03 != null) {
            this.printProductData(this.product03);
        }
    }

    public void sellProduct(Product product, int amount) {
        int stock;
        int newStock;
        String successMessage = "Venda realizada com sucesso";
        String failMessage = "Estoque insuficiente";

        if (this.product01 == product) {
            newStock = this.getNewProductStock(this.product01, amount, '-');
            if (newStock != 0) {
                this.product01.setAmount(newStock);
                System.out.println(successMessage);
            } else {
                System.out.println(failMessage);
            }
        }
        else if (this.product02 == product) {
            newStock = this.getNewProductStock(this.product02, amount, '-');
            if (newStock != 0) {
                this.product02.setAmount(newStock);
                System.out.println(successMessage);
            } else {
                System.out.println(failMessage);
            }
        }
        else if (this.product03 == product) {
            newStock = this.getNewProductStock(this.product03, amount, '-');
            if (newStock != 0) {
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
            newStock = this.getNewProductStock(this.product01, amount, '+');

            this.product01.setAmount(newStock);
            System.out.println(successMessage);
        }
        else if (this.product02 == product) {
            newStock = this.getNewProductStock(this.product02, amount, '+');

            this.product02.setAmount(newStock);
            System.out.println(successMessage);
        }
        else if (this.product03 == product) {
            newStock = this.getNewProductStock(this.product03, amount, '+');

            this.product03.setAmount(newStock);
            System.out.println(successMessage);
        }
    }

    private void printProductData(Product product) {
        System.out.println("Produto: " + product.getName() + " Quantidade: " + product.getAmount());
    }

    private int getNewProductStock(Product product, int amount, char operator) {

        int stock = product.getAmount();
        int newStock = 0;

        if (amount > stock && operator == '-') {
            return 0;
        }

        switch (operator) {
            case '+':
                newStock = stock + amount;
                break;
            case '-':
                newStock = stock - amount;
                break;
        }

        return newStock;
    }

}
