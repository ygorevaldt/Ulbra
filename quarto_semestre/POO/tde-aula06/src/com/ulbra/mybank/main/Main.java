package com.ulbra.mybank.main;

import com.ulbra.mybank.client.Client;
import com.ulbra.mybank.conta.ChekingAccount;
import com.ulbra.mybank.conta.SavingsAccount;

public class Main {
    public static void main(String[] args) {
        Client someClient = new Client("Algum cliente");
        ChekingAccount conta1 = new ChekingAccount(someClient);
        SavingsAccount conta2 = new SavingsAccount(someClient);
    }
}