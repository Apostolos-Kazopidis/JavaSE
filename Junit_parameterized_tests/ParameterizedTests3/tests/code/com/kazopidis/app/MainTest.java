package com.kazopidis.app;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.*;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.*;


public class MainTest {

    private static Stream<Arguments> provider1() {
        return Stream.of(
                Arguments.of("Tom", 1),
                Arguments.of("Bob", 2)
                );
    }
    @ParameterizedTest
    @MethodSource("provider1")
    void testRecords(String name, int id) {
        assertEquals("Bob", name);
        assertEquals(2, id);
    }

    private static List<Arguments> provider2() {
        List<Arguments> list = new ArrayList<>();
        list.add(Arguments.of("Pam", 3));
        return list;
    }
    @ParameterizedTest
    @MethodSource("provider2")
    void testRecords2(String name, int id) {
        assertEquals("Bob", name);
        assertEquals(2, id);
    }


    private static Stream<Arguments> testRecords3() {
        return Stream.of(
                Arguments.of("Tom", 1),
                Arguments.of("Bob", 2)
        );
    }
    @ParameterizedTest
    @MethodSource
    void testRecords3(String name, int id) {
        assertEquals("Bob", name);
        assertEquals(2, id);
    }

    @ParameterizedTest
    @MethodSource("com.kazopidis.app.TestData#testRecords3")
    void testRecords4(String name, int id) {
        assertEquals("Bob", name);
        assertEquals(2, id);
    }
}
