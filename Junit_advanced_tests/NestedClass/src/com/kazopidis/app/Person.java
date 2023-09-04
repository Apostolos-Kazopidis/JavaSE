package com.kazopidis.app;

public class Person {
    private String name;
    private String address;
    private Debit debit;
    private Credit credit;

    public Person(String name, String address, Debit debit, Credit credit) {
        this.name = name;
        this.address = address;
        this.debit = debit;
        this.credit = credit;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public Debit getDebit() {
        return debit;
    }

    public void setDebit(Debit debit) {
        this.debit = debit;
    }

    public Credit getCredit() {
        return credit;
    }

    public void setCredit(Credit credit) {
        this.credit = credit;
    }

    @Override
    public String toString() {
        return "Person{" +
                "name='" + name + '\'' +
                ", address='" + address + '\'' +
                ", debit=" + debit +
                ", credit=" + credit +
                '}';
    }
}
