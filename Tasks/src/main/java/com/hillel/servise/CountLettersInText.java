package com.hillel.servise;

import java.util.Arrays;
import java.util.Locale;

public class CountLettersInText {

//

    public Integer calculateLetters(String text) {
        return Arrays.stream(
                text.replaceAll("\\p{P}", "")
                        .replaceAll(" ", "")
                        .toLowerCase(Locale.ROOT).split(""))
                .toList()
                .size();
    }
}
