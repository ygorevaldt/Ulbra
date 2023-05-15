public abstract class Account {
    double Balance;
    String Number;
}

class CurrentAccount extends Account {
    double Limit;

    public CurrentAccount(double balance, String number, double limit) {
        this.Balance = balance;
        this.Number = number;
        this.Limit = limit;
    }
}
