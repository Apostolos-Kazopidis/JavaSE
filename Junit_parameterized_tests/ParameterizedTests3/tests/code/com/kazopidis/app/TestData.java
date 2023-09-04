package com.kazopidis.app;

import org.junit.jupiter.params.provider.Arguments;

import java.util.stream.Stream;

public class TestData {
    private static Stream<Arguments> testRecords3() {
        return Stream.of(
                Arguments.of("Tom", 1),
                Arguments.of("Bob", 2)
        );
    }
}
