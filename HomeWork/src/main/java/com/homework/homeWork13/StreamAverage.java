package com.homework.homeWork13;

// Имеется коллекция из Integes, использую стримы
// посчитать среденее значения всех чисел

import java.util.ArrayList;
import java.util.List;
import java.util.OptionalDouble;

public class StreamAverage {


    public static void main(String[] args) {

        List<Integer> number = new ArrayList<>();

        for (int i = 0; i < 10; i++)
            number.add(RandomGenerator.getIntValue(50));

        System.out.println(number);

        OptionalDouble streamAverage = number.stream().mapToInt(e -> e).average();
        if (streamAverage.isPresent()) {
            System.out.print(streamAverage.getAsDouble());
        }
    }
}

