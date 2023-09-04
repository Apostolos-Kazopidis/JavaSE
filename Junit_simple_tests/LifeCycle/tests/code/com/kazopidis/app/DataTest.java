package com.kazopidis.app;

import org.junit.jupiter.api.*;

import static org.junit.jupiter.api.Assertions.*;

public class DataTest {
    private static Data<Integer> data = null;
    private int instance = 0;
    @BeforeAll
    static void runBeforeAll() {
        data = new Data<>(1);
        System.out.println("Before all: " + data.getData());
    }
    @BeforeEach
    void runBeforeEach() {
        System.out.println("Before each running");
        instance++;
    }
    @Test
    void test1() {
        System.out.println("Running Test 1: " + instance);
        assertTrue(true);
    }
    @Test
    void test2() {
        System.out.println("Running Test 2: " + instance);
        assertTrue(true);
    }
    @AfterEach
    void runAfterEach() {
        System.out.println("After each running");
    }
    @AfterAll
    static void runAfterAll() {
        System.out.println("After All: " + data.getData());
    }
}
