public class Account {
    private int number;
    private double balance = 0.00;

    public int getNumber() {
        return this.number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    public double getBalance() {
        return this.balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }

    @Override
    public String toString() {
        return String.format("Número: %d Saldo: R$%.2f", this.number, this.balance);
    }
}
