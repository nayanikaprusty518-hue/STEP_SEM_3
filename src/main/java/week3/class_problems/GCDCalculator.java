package week3.class_problems;

import java.util.Scanner;

public class GCDCalculator {
    public static int findGCD(int number1, int number2) {
        int a = number1;
        int b = number2;
        
        while (b != 0) {
            int remainder = a % b;
            a = b;
            b = remainder;
        }
        
        return a;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter first number: ");
        int number1 = scanner.nextInt();
        System.out.print("Enter second number: ");
        int number2 = scanner.nextInt();
        
        int gcd = findGCD(number1, number2);
        System.out.println("The GCD of " + number1 + " and " + number2 + " is " + gcd);
        
        scanner.close();
    }
}