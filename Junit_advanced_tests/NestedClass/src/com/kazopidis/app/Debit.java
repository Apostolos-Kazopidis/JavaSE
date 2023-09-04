package com.kazopidis.app;

public class Debit {
    int balance;

    public Debit(int balance) {
        this.balance = balance;
    }

    public int getBalance() {
        return balance;
    }

    public void setBalance(int balance) {
        this.balance = balance;
    }

    @Override
    public String toString() {
        return "Debit{" +
                "balance=" + balance +
                '}';
    }
}
