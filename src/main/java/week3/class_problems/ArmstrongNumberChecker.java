package week3.class_problems;

import java.util.Scanner;

public class ArmstrongNumberChecker {
    public static boolean isArmstrong(int number) {
        int origNumber = number;
        int sum = 0;
        int numDigits = String.valueOf(number).length();
        
        while (number > 0) {
            int digit = number % 10;
            int power = 1;
            for (int i = 0; i < numDigits; i++) {
                power *= digit;
            }
            sum += power;
            number = number / 10;
        }
        
        return origNumber == sum;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter a number: ");
        int number = scanner.nextInt();
        
        boolean result = isArmstrong(number);
        System.out.println("Is the number " + number + " an Armstrong number? " + (result ? "Yes" : "No"));
        
        scanner.close();
    }
}