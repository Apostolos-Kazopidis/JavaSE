package com.kazopidis.app;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class MainTest {

    @Test
    void testSwap() {
        int[] array = {1, 5, 3, 6, 9};
        Main.swap(array,0,3);
        assertEquals(array[0], 6);
        assertEquals(array[3], 1);
    }
}