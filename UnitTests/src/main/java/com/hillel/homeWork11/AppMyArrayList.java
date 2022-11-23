package com.hillel.homeWork11;

public class AppMyArrayList {

    public static void main(String[] args) {
        MyArrayList1 my = new MyArrayList1();
        MyArrayList1 my1 = new MyArrayList1(6);

        System.out.println(my.add("A"));
        System.out.println(my);
        my.add("B");
        my.add("C");
        System.out.println(my);
        my.add(1, "D");
        my.add(4, "F");
        System.out.println(my);
        my.add("E");
        my.add("G");

        my1.add("A");
        System.out.println(my1);

        my.delete("A");
        my.delete("G");
        System.out.println(my);

        System.out.println(my.get(1));

        System.out.println(my.contain("E"));
        System.out.println(my.contain("B"));
        System.out.println(my.equals(my1));

        my.clear();

        my.add("A");

        System.out.println(my);
        System.out.println(my1);
        System.out.println(my.equals(my1));
    }
}
