package Operators;

import java.util.ArrayList;

public class Transfer implements Operator {
    @Override
    public double execute(double balance, double value) {
        if (balance < value) {
            System.out.println("Saldo insuficiente para realizar a transferência");
            return balance;
        }
        return balance - value;
    }
}
