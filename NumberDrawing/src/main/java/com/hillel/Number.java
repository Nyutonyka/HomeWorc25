package com.hillel;

import java.util.ArrayList;
import java.util.List;

public class Number {

    static List<String> zero;
    static List<String> one;
    static List<String> two;
    static List<String> three;
    static List<String> four;
    static List<String> five;
    static List<String> six;
    static List<String> seven;
    static List<String> eight;
    static List<String> nine;

    public static List<String> numberZero(){
        zero = new ArrayList<>();
        zero.add(0,"  @@@    ");
        zero.add(1," @@ @@   ");
        zero.add(2,"@@   @@  ");
        zero.add(3,"@@   @@  ");
        zero.add(4,"@@   @@  ");
        zero.add(5,"@@   @@  ");
        zero.add(6," @@ @@   ");
        zero.add(7,"  @@@    ");
        return zero;
    }

    public static List<String> numberOne(){
        one = new ArrayList<>();
        one.add(0,"    @@  ");
        one.add(1,"   @@@  ");
        one.add(2,"  @@@@  ");
        one.add(3," @@ @@  ");
        one.add(4,"@@  @@  ");
        one.add(5,"    @@  ");
        one.add(6,"    @@  ");
        one.add(7,"    @@  ");
        return one;
    }

    public static List<String> numberTwo(){
        two = new ArrayList<>();
        two.add(0,"  @@@    ");
        two.add(1,"@@   @@  ");
        two.add(2,"@@   @@  ");
        two.add(3,"    @@   ");
        two.add(4,"   @@    ");
        two.add(5,"  @@     ");
        two.add(6," @@      ");
        two.add(7,"@@@@@@@  ");
        return two;
    }

    public static List<String> numberThree(){
        three = new ArrayList<>();
        three.add(0,"  @@@    ");
        three.add(1,"@@   @@  ");
        three.add(2,"     @@  ");
        three.add(3,"   @@    ");
        three.add(4,"    @@   ");
        three.add(5,"@@   @@  ");
        three.add(6,"@@   @@  ");
        three.add(7,"  @@@    ");
        return three;
    }

    public static List<String> numberFour(){
        four = new ArrayList<>();
        four.add(0,"@@   @@  ");
        four.add(1,"@@   @@  ");
        four.add(2,"@@   @@  ");
        four.add(3,"@@   @@  ");
        four.add(4,"@@@@@@@  ");
        four.add(5,"     @@  ");
        four.add(6,"     @@  ");
        four.add(7,"     @@  ");
        return four;
    }

    public static List<String> numberFive(){
        five = new ArrayList<>();
        five.add("@@@@@@@  ");
        five.add("@@       ");
        five.add("@@       ");
        five.add("@@@@     ");
        five.add("     @@  ");
        five.add("     @@  ");
        five.add("@@   @@  ");
        five.add("  @@@    ");
        return five;
    }

    public static List<String> numberSix(){
        six = new ArrayList<>();
        six.add("  @@@    ");
        six.add("@@   @@  ");
        six.add("@@       ");
        six.add("@@@@     ");
        six.add("@@   @@  ");
        six.add("@@   @@  ");
        six.add("@@   @@  ");
        six.add("  @@@    ");
        return six;
    }

    public static List<String> numberSeven() {
        seven = new ArrayList<>();
        seven.add("@@@@@@@  ");
        seven.add("     @@  ");
        seven.add("     @@  ");
        seven.add("    @@   ");
        seven.add("   @@    ");
        seven.add("  @@     ");
        seven.add(" @@      ");
        seven.add("@@       ");
        return seven;
    }

    public static List<String> numberEight(){
        eight = new ArrayList<>();
        eight.add("  @@@    ");
        eight.add("@@   @@  ");
        eight.add("@@   @@  ");
        eight.add("  @@@    ");
        eight.add(" @@ @@   ");
        eight.add("@@   @@  ");
        eight.add("@@   @@  ");
        eight.add("  @@@    ");
        return eight;
    }

    public static List<String> numberNine(){
        nine = new ArrayList<>();
        nine.add("  @@@    ");
        nine.add("@@   @@  ");
        nine.add("@@   @@  ");
        nine.add("@@   @@  ");
        nine.add(" @@ @@@  ");
        nine.add("     @@  ");
        nine.add("@@   @@  ");
        nine.add("  @@@    ");
        return nine;
    }
}
