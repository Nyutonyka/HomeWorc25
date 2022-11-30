package com.homework.homeWork13;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;

class StreamUppercaseTest {
    @Test
    void filterNull() {

        List<String> list = new ArrayList<>();
        list.add("a");
        list.add(null);
        list.add("b");
        list.add("c");
        list.add(null);
        List<Pair> pairList = StreamUppercase.strUpperCase(list);

        assertFalse(pairList.contains(null));
        assertEquals(3, pairList.size());
    }

    @Test
    void strUpperCase() {

        List<String> list = new ArrayList<>();
        list.add("a");
        list.add("b");
        list.add("c");
        List<Pair> pairList = StreamUppercase.strUpperCase(list);

        assertEquals(3, pairList.size());
        assertEquals("a", pairList.get(0).getlCase());
        assertEquals("A", pairList.get(0).getuCase());
    }
}