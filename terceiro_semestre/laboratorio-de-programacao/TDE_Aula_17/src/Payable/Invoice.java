package Payable;

public class Invoice implements Payable {
    @Override
    public void pay() {
        System.out.println("Pagar fatura");
    }

    @Override
    public void checkPayment() {
        System.out.println("Conferir pagamento da fatura");
    }
}
