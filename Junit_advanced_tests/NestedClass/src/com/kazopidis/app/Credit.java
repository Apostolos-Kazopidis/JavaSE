package com.kazopidis.app;

public class Credit {
    private int balance;
    static public int LIMIT = 1000;

    public Credit(int balance) {
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
        return "Credit{" +
                "balance=" + balance +
                '}';
    }
}
