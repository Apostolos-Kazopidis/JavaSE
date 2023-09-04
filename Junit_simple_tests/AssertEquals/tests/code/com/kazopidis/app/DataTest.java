package com.kazopidis.app;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;


public class DataTest {
    @Test
    void testConstructor() {
        Data<Integer> d = new Data<>(1);
        assertEquals(1, d.getData());
    }
    @Test
    void testSetter() {
        Data<Integer> d = new Data<>(1);
        d.setData(2);
        assertEquals(2, d.getData());
    }
    @Test
    void testDoubleWithoutDelta() {
        Data<Double> d1 = new Data<>(3.6);
        Data<Double> d2 = new Data<>(3.5);
        Data<Double> d = new Data<>(d1.getData()-d2.getData());
        assertEquals(0.1, d.getData(), "Floating point error");
    }
    @Test
    void testDoubleWithDelta() {
        Data<Double> d1 = new Data<>(3.6);
        Data<Double> d2 = new Data<>(3.5);
        Data<Double> d = new Data<>(d1.getData()-d2.getData());
        assertEquals(0.1, d.getData(), 0.001, "Floating point error");
    }
    @Test
    void testObjectEquals() {
        Data<Double> d1 = new Data<>(3.6);
        Data<Double> d2 = new Data<>(3.6);
        assertEquals(d1, d2);
    }
    @Test
    void testObjectSame() {
        Data<Double> d1 = new Data<>(3.6);
        Data<Double> d2 = new Data<>(3.6);
        assertSame(d1, d2);
    }
}
