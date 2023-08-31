import Account.CheckingAccount;
import Account.SalaryAccount;
import Account.SavingsAccount;
import Operators.Deposit;
import Operators.Transfer;
import Operators.Withdraw;

public class Main {
    public static void main(String[] args) {
        CheckingAccount checkingAccount = new CheckingAccount();
        SalaryAccount salaryAccount = new SalaryAccount();
        SavingsAccount savingsAccount = new SavingsAccount();

        checkingAccount.executeOperation(new Deposit(), 200);
        salaryAccount.executeOperation(new Deposit(), 2000);
        savingsAccount.executeOperation(new Deposit(), 20000);

        checkingAccount.executeOperation(new Withdraw(), 300);
        salaryAccount.executeOperation(new Withdraw(), 200);
        savingsAccount.executeOperation(new Transfer(), 200, checkingAccount);

        checkingAccount.executeOperation(new Withdraw(), 200);
    }
}