package Payable;

public class Check implements Payable {
    @Override
    public void pay() {
        System.out.println("Pagamento com cheque.");
    }

    @Override
    public void checkPayment() {
        System.out.println("Conferir pagamento com check.");
    }
}
