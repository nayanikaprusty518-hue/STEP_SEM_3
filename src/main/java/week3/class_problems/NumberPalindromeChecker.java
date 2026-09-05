package week3.class_problems;

import java.util.Scanner;

public class NumberPalindromeChecker {
    public static boolean isPalindrome(int number) {
        int origNumber = number;
        int reversedNumber = 0;
        
        while (number > 0) {
            int digit = number % 10;
            reversedNumber = reversedNumber * 10 + digit;
            number = number / 10;
        }
        
        return origNumber == reversedNumber;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter a number: ");
        int number = scanner.nextInt();
        
        boolean result = isPalindrome(number);
        System.out.println("Is the number " + number + " a Palindrome? " + (result ? "Yes" : "No"));
        
        scanner.close();
    }
}