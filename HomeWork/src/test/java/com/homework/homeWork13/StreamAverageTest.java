package com.homework.homeWork13;

import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.OptionalDouble;

import static org.junit.jupiter.api.Assertions.assertEquals;

class StreamAverageTest {

    @Test
    void streamAverage() {

        List<Integer> number = List.of(2, 4, 8, 6);
        OptionalDouble result = OptionalDouble.of(5.0);

        assertEquals(result, StreamAverage.streamAverage(number));
    }

    @Test
    void streamAverage1() {

        List<Integer> number = List.of(0, 0, 0, 0);
        OptionalDouble result = OptionalDouble.of(0.0);

        assertEquals(result, StreamAverage.streamAverage(number));
    }

    @Test
    void streamAverage2() {

        List<Integer> number = List.of(2, -4, 8, 6, 0);
        OptionalDouble result = OptionalDouble.of(2.4);

        assertEquals(result, StreamAverage.streamAverage(number));
    }
}