package com.kazopidis.app;

import org.junit.jupiter.api.Test;

import java.time.Duration;
import java.util.Arrays;
import java.util.Random;

import static org.junit.jupiter.api.Assertions.*;

class MainTest {
    @Test
    void testSwap() {
        int[] array = {1, 2, 3, 4};
        Main.swap(array, 1, 3);
        assertArrayEquals(new int[] {1, 4, 3, 2}, array);
    }

    @Test
    void testSwapIllegalArgument1() {
        int[] array = {1, 2, 3, 4};

        assertThrows(IllegalArgumentException.class, ()->{
            Main.swap(array, 5, 2);
        });
    }

    @Test
    void testSorted() {
        int[] array = {1, 2, 3, 4};

        Main.selectionSort(array);
        assertTrue(Main.checkSorted(array));
    }

    @Test
    void testDuration() {
        int[] array = new int[10000];
        Random r = new Random();
        Arrays.setAll(array, n->r.nextInt(100));
        assertTimeout(Duration.ofMillis(100), ()->
                Main.selectionSort(array));
    }

    @Test
    void failed() {
        fail("a failure");
    }

}