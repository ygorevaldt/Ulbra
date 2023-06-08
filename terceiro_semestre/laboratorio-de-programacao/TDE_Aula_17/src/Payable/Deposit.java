package Payable;

public class Deposit implements Payable {
    @Override
    public void pay() {
        System.out.println("Depositar valor");
    }

    @Override
    public void checkPayment() {
        System.out.println("Conferir deposito");
    }
}
