package com.hillel.servis;

import java.util.Scanner;

public class ScannerN {

    public static String inputNumber(){
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter digits...");
        String lineNumber = null;
        try {
            lineNumber = sc.nextLine();
        } catch (NumberFormatException e) {
            System.out.println("It's not a number!");
        }
        sc.close();
        return lineNumber;
    }
}
