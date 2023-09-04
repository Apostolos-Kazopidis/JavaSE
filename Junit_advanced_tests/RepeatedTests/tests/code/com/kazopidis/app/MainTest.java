package com.kazopidis.app;

import org.junit.jupiter.api.*;

import java.util.Random;

import static org.junit.jupiter.api.Assertions.*;


public class MainTest {
    @DisplayName("Selection Sort")
    @RepeatedTest(value=10, name="{displayName}: repetition {currentRepetition}/{totalRepetitions}")
    void testSelectionSort() {
        int[] array;

        Random r = new Random();
        int dim = r.nextInt(1000);
        System.out.println("Dimension: " + dim);
        array = new int[dim];
        for (int i=0; i<array.length; i++)
            array[i] = r.nextInt(200);

        Main.selectionSort(array);
        assertTrue(Main.checkSorted(array));
    }

    @DisplayName("Selection Sort")
    @RepeatedTest(value=5, name="{displayName}: repetition {currentRepetition}/{totalRepetitions}")
    void testSelectionSort2(TestReporter reporter, RepetitionInfo repetitionInfo) {
        int[] array;

        Random r = new Random();
        int dim = r.nextInt(1000);
        System.out.println("Dimension: " + dim);
        array = new int[dim];
        for (int i=0; i<array.length; i++)
            array[i] = r.nextInt(200);

        Main.selectionSort(array);
        reporter.publishEntry("Repetition", String.valueOf(repetitionInfo.getCurrentRepetition()));
        reporter.publishEntry("Total Repetitions", String.valueOf(repetitionInfo.getTotalRepetitions()));
        assertTrue(Main.checkSorted(array));
    }

}
