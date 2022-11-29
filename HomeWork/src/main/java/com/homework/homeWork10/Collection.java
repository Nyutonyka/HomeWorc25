package com.homework.homeWork10;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Collection {

    static public List<Integer> collection;

    public static void main(String[] args) {

        collection = new ArrayList<>();

        collection.add(1);
        collection.add(2);
        collection.add(1);
        collection.add(3);
        collection.add(2);
        collection.add(0);
        collection.add(1);
        collection.add(4);
        collection.add(5);

        for (Integer item : collection) {
            System.out.print(item);
        }
        System.out.print("\n");

        //Set<Number> numberSet = Service.removingDuplicates();

        Set<java.lang.Number> numberSet = new HashSet<>(collection);

        for (java.lang.Number item : numberSet) {
            System.out.print(item);
        }
    }
}
