package com.kazopidis.app;

import org.junit.jupiter.api.*;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.*;


import static org.junit.jupiter.api.Assertions.*;


public class MainTest {
    @ParameterizedTest
    @EnumSource(Day.class)
    void testDays(Day day) {
        assertEquals("WEDNESDAY", day.name());
    }

    @ParameterizedTest
    @CsvSource({"Bob, 1", "John, 2"})
    void testCsvValues(String str1, String str2) {
        assertEquals("Bob", str1);
        assertEquals("1", str2);
    }

    @ParameterizedTest
    @CsvFileSource(resources = "/csv.csv", delimiter = ',', numLinesToSkip = 1)
    void testCsvValues2(String str1, String str2) {
        assertEquals("Tom", str1);
        assertEquals("1", str2);
    }
}
