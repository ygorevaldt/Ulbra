package Account;

import Operators.Deposit;
import Operators.Operator;

public abstract class Account {
    private double balance = 0.0;

    public void executeOperation(Operator operator, double value) {
        this.balance = operator.execute(this.balance, value);
    }

    public void executeOperation(Operator operator, double value, Account account) {
        this.balance = operator.execute(this.balance, value);
        operator = new Deposit();
        account.executeOperation(operator, value);
    }

}
