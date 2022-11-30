package com.homework.homeWork13;

//Имеется коллекция из String, отфильтровать и вывести на экран все значения,
// которые написаны в loverCase and length = 4

import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class StreamLoverCase {

    static String text;
    static int length;

    public static void main(String[] args) {
        text = "Java is a programming language and a platform. " +
                "Java is a high level, robust, object-oriented " +
                "and secure programming language.";
        length = 4;

        List<String> t = Stream
                .of(text.split(" "))
                .collect(Collectors.toList());

        System.out.println(t);
        System.out.println(strLoverCase(t, length));
    }

    public static List<String> strLoverCase(List<String> t, int length) {
        return t.stream()
                .filter(Objects::nonNull)
                .filter(s -> s.length() == length && s.equals(s.toLowerCase()))
                .toList();
    }
}
