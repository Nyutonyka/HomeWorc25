package com.homework.homeWork13;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

//Имеется коллекция из String, привести все стринги в UPPERCASE и вернуть коллекцию List<Pair>
//in: "one", "two", ...
//out: {"one":"ONE"}, {"two", "TWO"}, ...

public class StreamUppercase {

    public static void main(String[] args) {

        List<String> number = new ArrayList<>();
        number.add("one");
        number.add("two");
        number.add(null);
        number.add("three");
        System.out.println(number);
        System.out.println(strUpperCase(number));

    }

    public static List<Pair> strUpperCase(List<String> number){
        List<Pair> numberUpp = number.stream()
                .filter(Objects::nonNull)
                .map(n -> new Pair(n, n.toUpperCase()))
                .toList();
        return numberUpp;
    }
}

