package com.hillel.homeWork12;

public class AppMyArrayList {

    public static void main(String[] args) {
        MyArrayList1 my = new MyArrayList1();

        System.out.println(my.add("A"));
        System.out.println(my);
        my.add("B");
        my.add("C");
        my.add("G");
        System.out.println(my);
        my.add(1, "D");
        my.add(4, "F");
        System.out.println(my);
        my.add("E");
        System.out.println(my.add("A"));
        System.out.println(my);

        System.out.println(my.get(0).equals(my.get(7)));

        my.delete("A");
        my.delete("G");
        System.out.println(my);

        System.out.println(my.get(1));

        System.out.println(my.contain("E"));
        System.out.println(my.contain("G"));

        my.clear();

        System.out.println(my);

    }
}
