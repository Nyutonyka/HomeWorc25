package com.hillel;

import com.hillel.servis.DrawingNumber;
import com.hillel.servis.ScannerN;

public class MainRun {

    public static void main(String[] args) {

        String lineNumber = ScannerN.inputNumber();
        DrawingNumber.getLineNumber(lineNumber);

    }
}
