package com.kazopidis.app;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class MainTest {
    @Test
    void testSwap() {
        int[] array = {1, 2, 3, 4};
        Main.swap(array, 1, 3);
        assertEquals(array[1], 4);
        assertEquals(array[3], 2);
    }

}