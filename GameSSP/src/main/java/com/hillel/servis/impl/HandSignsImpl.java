package com.hillel.servis.impl;

import com.hillel.dto.Signs;
import com.hillel.dto.Symbol;
import com.hillel.servis.HandSigns;

import java.util.Collections;
import java.util.Stack;

public class HandSignsImpl implements HandSigns {

    @Override
    public Stack<Signs> chainOfSigns() {
        Stack<Signs> chainOfSigns = new Stack<>();
        for (Symbol symbol : Symbol.values()) {
            chainOfSigns.add(new Signs(symbol));
        }
        shuffleSigns(chainOfSigns);
        return chainOfSigns;
    }

    @Override
    public Signs getHandSigns(Stack<Signs> chainOfSigns) {
        shuffleSigns(chainOfSigns);
        return chainOfSigns.peek();
    }

    @Override
    public void shuffleSigns(Stack<Signs> handSigns) {
        Collections.shuffle(handSigns);
    }
}
