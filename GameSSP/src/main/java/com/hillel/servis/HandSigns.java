package com.hillel.servis;

import com.hillel.dto.Signs;

import java.util.Stack;

public interface HandSigns {

    Stack<Signs> chainOfSigns();

    Signs getHandSigns(Stack<Signs> handSigns);

    void shuffleSigns(Stack<Signs> handSign);
}
