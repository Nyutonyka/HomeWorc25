package com.hillel.servis.impl;

import com.hillel.dto.Signs;
import com.hillel.servis.HandSigns;
import org.junit.jupiter.api.Test;

import java.util.Stack;

import static org.junit.jupiter.api.Assertions.*;

class HandSignsImplTest {

    @Test
    void getHand() {

    }

    @Test
    void chainOfSigns() {
        HandSigns hs = new HandSignsImpl();
        Stack<Signs> handSign = hs.chainOfSigns();
        assertFalse(handSign.isEmpty());
        assertEquals(3, handSign.size());
    }

    @Test
    void getHandSigns() {
        HandSigns hs = new HandSignsImpl();
        Stack<Signs> handSign = hs.chainOfSigns();

        System.out.println(handSign);

        assertFalse(handSign.isEmpty());
        assertEquals(3, handSign.size());
        System.out.println(hs.getHandSigns(handSign));
        hs.getHandSigns(handSign);
        assertEquals(3, handSign.size());
    }
}