package com.hillel.servis;

import com.hillel.Number;

import java.util.Arrays;
import java.util.List;

public class DrawingNumber {


    public static void getLineNumber(String lineNumber){
        List<String> numberList = Arrays.stream(lineNumber.split("")).toList();
        numberList.stream().map(Integer::parseInt).toList();
        drawing(numberList);
    }

    public static  void drawing(List<String> numberList) {
        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < numberList.size(); j++) {
                switch (numberList.get(j)) {
                    case "0" -> System.out.print(Number.numberZero().get(i));
                    case "1" -> System.out.print(Number.numberOne().get(i));
                    case "2" -> System.out.print(Number.numberTwo().get(i));
                    case "3" -> System.out.print(Number.numberThree().get(i));
                    case "4" -> System.out.print(Number.numberFour().get(i));
                    case "5" -> System.out.print(Number.numberFive().get(i));
                    case "6" -> System.out.print(Number.numberSix().get(i));
                    case "7" -> System.out.print(Number.numberSeven().get(i));
                    case "8" -> System.out.print(Number.numberEight().get(i));
                    case "9" -> System.out.print(Number.numberNine().get(i));
                }
            }
            System.out.print("\n");
        }
    }

}
