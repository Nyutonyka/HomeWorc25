package com.hillel.dto;

import lombok.Data;
import lombok.experimental.Accessors;

@Data
@Accessors(chain = true)
public class Signs {

    private final Symbol signs;

    @Override
    public String toString() {
        return String.format("%s", signs.getSymbol());
    }

    public int getIndex(){
        return signs.getIndex();
    }
}
