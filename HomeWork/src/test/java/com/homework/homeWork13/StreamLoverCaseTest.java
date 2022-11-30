package com.homework.homeWork13;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class StreamLoverCaseTest {

    @Test
    void strLoverCase() {

        List<String> s = List.of("Java", "is", "a", "high", "level");
        List<String> result = List.of("is");
        int length = 2;

        assertEquals(result, StreamLoverCase.strLoverCase(s,length));
    }

    @Test
    void strLoverCase1() {

        List<String> s = List.of("Java", "is", "a", "high", "level");
        List<String> result = List.of("high");
        int length = 4;

        assertEquals(result, StreamLoverCase.strLoverCase(s,length));
    }

    @Test
    void strLoverCase2() {

        List<String> s = new ArrayList<>();
        s.add("Java");
        s.add(null);
        s.add("is");
        s.add("high");
        int length = 4;
        List<String> result = List.of("high");
        List<String> actual = StreamLoverCase.strLoverCase(s,length);

        assertEquals(result, StreamLoverCase.strLoverCase(s,length));
        assertFalse(actual.contains(null));
    }
}