package com.kazopidis.app;

public class Main {
    static long fib(long n) {
        return n < 2 ? 1: fib(n-1) + fib(n-2) ;
    }

    public static void main(String[] args) {

    }
}

