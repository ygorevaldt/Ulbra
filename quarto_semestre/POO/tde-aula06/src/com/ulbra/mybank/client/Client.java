package com.ulbra.mybank.client;

import com.ulbra.mybank.conta.Account;

import java.util.ArrayList;

public class Client {
    private String name;
    private Age age;
    private ArrayList<Account> accounts = new ArrayList<>();

    public Client (String name) {
        this.name = name;
    }

    public String getName () {
        return this.name;
    }

    public void setName (String name) {
        this.name = name;
    }

    public Age getAge () {
        return this.age;
    }

    public void setAge (Age age) {
        this.age = age;
    }

    public ArrayList<Account> getAccounts () {
        return this.accounts;
    }

    public void setAccounts (Account account) {
        this.accounts.add(account);
    }
}
