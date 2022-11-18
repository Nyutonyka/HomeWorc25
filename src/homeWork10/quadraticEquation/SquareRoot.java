package homeWork10.quadraticEquation;

import java.util.Scanner;

public class SquareRoot {

    static double a;
    static double b;
    static double c;
    static double D;

    public static void main(String[] args) {

        System.out.println("The program solves a quadratic equation of the form:");
        System.out.println("ax^2 + bx + c = 0");

        Scanner sc = new Scanner(System.in);
        System.out.print("Enter a: ");
        a = sc.nextDouble();
        System.out.print("Enter b: ");
        b = sc.nextDouble();
        System.out.print("Enter c: ");
        c = sc.nextDouble();

        //Вычисляем дискриминант
        D = b * b - 4 * a * c;

        if (D > 0) {
            double x1 = (-b - Math.sqrt(D)) / (2 * a);
            double x2 = (-b + Math.sqrt(D)) / (2 * a);
            System.out.println("Equation roots: x1 = " + x1 + ", x2 = " + x2);
        } else if (D == 0) {
            double x;
            x = -b / (2 * a);
            System.out.println("The equation has only one root: x = " + x);
        } else {
            System.out.println("The equation has no real roots.");
        }
    }
}
