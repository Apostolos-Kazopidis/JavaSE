package com.kazopidis.app;

import org.junit.jupiter.api.*;

import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.api.Assumptions.*;


public class DataTest {
    @BeforeAll
    static void checkOS() {
        System.out.println(System.getProperty("os.name"));
        System.out.println(System.getProperty("java.version"));
        assumeTrue(System.getProperty("os.name").equals("Windows 10"));
    }
    @Test
    void test1() {
        System.out.println("Running Test 1: ");
        assertTrue(true);
    }
    @Test
    void test2() {
        assumingThat(
                ()-> System.getProperty("java.version").equals("20.0.2"),
                ()-> {
                    System.out.println("Running Test 2: ");
                }
        );
        assertTrue(true);
    }
    @Test
    void test3() {
        assumeTrue(System.getProperty("java.version").equals("17"));
        System.out.println("Running Test 3: ");
        assertTrue(true);
    }
    @Test
    void test4() {
        System.out.println("Running Test 4: ");
        assertTrue(true);
    }
}
