package com.ulbra.mybank.conta;

import com.ulbra.mybank.client.Client;

import java.util.Date;

public abstract class Account {
    private int number;
    private double balance;
    private Client client;

    public Account (Client client) {
        this.client = client;
    }

    public void deposit (double value) {
        this.balance += value;
    }

    public void transfer (Date date) {

    }

    public double getBalance () {
        return this.balance;
    }
}
