package Operators;

import Account.Account;

import java.util.ArrayList;

public class Deposit implements Operator {
    @Override
    public double execute(double balance, double value) {
        return balance + value;
    }

}
