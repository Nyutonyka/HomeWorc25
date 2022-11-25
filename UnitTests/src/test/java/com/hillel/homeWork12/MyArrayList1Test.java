package com.hillel.homeWork12;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import static org.junit.jupiter.api.Assertions.*;


class MyArrayList1Test {

    @Test
    void add() {
        MyArrayList1 list = new MyArrayList1();
        list.add("A");
        list.add("B");
        Object element2 = list.get(1);

        assertEquals("A", list.get(0));
        assertEquals("B", element2);
        assertTrue(list.add("A"));
    }

    @Test
    void testAdd() {
        MyArrayList1 list1 = new MyArrayList1();
        list1.add(0,"A");
        list1.add(3, "B");

        assertEquals("A", list1.get(0));
        assertEquals("B", list1.get(3));
        assertTrue(list1.add(2,"C"));
    }

    @Test
    void delete() {
        MyArrayList1 list2 = new MyArrayList1();
        list2.add("A");
        list2.add("B");

        assertEquals("A", list2.get(0));
        assertEquals("B", list2.get(1));

        list2.delete("B");
        list2.delete("A");

        assertNull(list2.get(0));
        assertNull(list2.get(2));
    }

    @ParameterizedTest
    @ValueSource(ints = {0,1,2,3})
    void get(int index) {
        MyArrayList1 list3 = new MyArrayList1();
        list3.add(0,"A");
        list3.add(1,"A");
        list3.add(2,"A");
        list3.add(3,"A");

        assertEquals("A", list3.get(index));
    }

    @Test
    void contain() {
        MyArrayList1 list4 = new MyArrayList1();
        list4.add("A");
        list4.add(1,"B");

        assertTrue(list4.contain("A"));
        assertTrue(list4.contain("B"));
        assertFalse(list4.contain("C"));
    }

    @Test
    void testEquals() {
        MyArrayList1 list5 = new MyArrayList1();
        list5.add("A");
        list5.add("B");
        list5.add("A");

        assertEquals(list5.get(0), list5.get(2));
        assertNotEquals(list5.get(0), list5.get(1));
    }

    @Test
    void clear() {
        MyArrayList1 list6 = new MyArrayList1();
        list6.add("A");

        assertTrue(list6.clear());
        assertNull(list6.get(0));
    }

    @Test
    void size() {
        MyArrayList1 list7 = new MyArrayList1();
        list7.clear();
        list7.add("A");

        assertEquals(1, list7.size());
    }
}