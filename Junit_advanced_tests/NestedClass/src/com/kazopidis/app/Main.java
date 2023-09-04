package com.kazopidis.app;

public class Main {
    public static void main(String[] args) {
        Person p = new Person("Bob", "123 str.", new Debit(0), new Credit(1000));

        System.out.println(p);
    }
}

