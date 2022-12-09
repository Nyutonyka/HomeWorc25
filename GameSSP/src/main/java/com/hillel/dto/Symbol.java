package com.hillel.dto;

public enum Symbol {
    STONE('◈', 1),
    SCISSORS('✂', 2),
    PAPER('▱', 3);

    private final char symbol;
    private final int index;

    public final char getSymbol() {
        return symbol;
    }

    public final int getIndex(){
        return index;
    }

    Symbol(char symbol, int index){
        this.symbol = symbol;
        this.index = index;
    }
}
