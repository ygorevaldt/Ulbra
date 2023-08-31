package Operators;

import java.util.ArrayList;

public class Withdraw implements Operator {
    @Override
    public double execute(double balance, double value) {
        if (balance < value) {
            System.out.println("Saldo insuficiente para realizar o saque");
            return balance;
        }
        return balance - value;
    }
}
