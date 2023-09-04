package com.kazopidis.app;

import org.junit.jupiter.api.*;

import static org.junit.jupiter.api.Assertions.*;


public class DataTest {
    @Test
    @Tag("category-1")
    @DisplayName("Test 1")
    void test1() {
        System.out.println("Running Test 1: ");
        assertTrue(true);
    }
    @Test
    @Tag("category-1")
    @DisplayName("Test 2")
    void test2() {
        System.out.println("Running Test 2: ");
        assertTrue(true);
    }
    @Disabled
    @Test
    @Tag("category-2")
    @DisplayName("Test 3")
    void test3() {
        System.out.println("Running Test 3: ");
        assertTrue(true);
    }
    @Test
    @Tag("category-2")
    @DisplayName("Test 4")
    void test4() {
        System.out.println("Running Test 4: ");
        assertTrue(true);
    }
}
