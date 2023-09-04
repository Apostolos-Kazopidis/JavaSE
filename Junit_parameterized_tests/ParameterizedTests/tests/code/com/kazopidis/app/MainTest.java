package com.kazopidis.app;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.NullAndEmptySource;
import org.junit.jupiter.params.provider.ValueSource;


import static org.junit.jupiter.api.Assertions.*;


public class MainTest {
    @ParameterizedTest
    @ValueSource(ints={1,2,3,4,5})
    void testEven(int number) {
        assertEquals(0, number % 2);
    }

    @ParameterizedTest
    @ValueSource(strings={"a", "abcdef", "abc"})
    @NullAndEmptySource
    void testStringLength(String str) {
        if (str==null)
            fail();
        assertTrue(str.length()<=3);
    }
}
