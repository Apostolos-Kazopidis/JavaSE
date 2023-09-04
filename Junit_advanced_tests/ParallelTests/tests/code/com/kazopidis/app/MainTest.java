package com.kazopidis.app;

import org.junit.jupiter.api.*;
import org.junit.jupiter.api.parallel.Execution;
import org.junit.jupiter.api.parallel.ExecutionMode;

import java.time.Instant;
import java.util.Random;

import static org.junit.jupiter.api.Assertions.*;


public class MainTest {
    @DisplayName("Selection Sort")
    @RepeatedTest(value=1000, name="{displayName}: repetition {currentRepetition}/{totalRepetitions}")
    @Execution(ExecutionMode.CONCURRENT)
    void testSelectionSort1(TestReporter reporter, RepetitionInfo repetitionInfo) {
        int[] array;

        Random r = new Random();
        int dim = r.nextInt(1000);
        array = new int[dim];
        for (int i=0; i<array.length; i++)
            array[i] = r.nextInt(200);

        Main.selectionSort(array);
        reporter.publishEntry("Test 1 / " + repetitionInfo.getCurrentRepetition());
        reporter.publishEntry("--> " + Instant.now());
        reporter.publishEntry("--> " + Thread.currentThread().getName());
        assertTrue(Main.checkSorted(array));
    }

    @DisplayName("Selection Sort")
    @RepeatedTest(value=1000, name="{displayName}: repetition {currentRepetition}/{totalRepetitions}")
    @Execution(ExecutionMode.CONCURRENT)
    void testSelectionSort2(TestReporter reporter, RepetitionInfo repetitionInfo) {
        int[] array;

        Random r = new Random();
        int dim = r.nextInt(1000);
        array = new int[dim];
        for (int i=0; i<array.length; i++)
            array[i] = r.nextInt(200);

        Main.selectionSort(array);
        reporter.publishEntry("Test 2 / " + repetitionInfo.getCurrentRepetition());
        reporter.publishEntry("--> " + Instant.now());
        reporter.publishEntry("--> " + Thread.currentThread().getName());
        assertTrue(Main.checkSorted(array));
    }
}
