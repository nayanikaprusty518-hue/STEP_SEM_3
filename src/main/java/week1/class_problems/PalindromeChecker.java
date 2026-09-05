package week1.class_problems;

import java.util.Scanner;

public class PalindromeChecker {
    public static boolean isPalindromeIterative(String text) {
        if (text == null) return false;
        String cleaned = text.replaceAll("[^a-zA-Z0-9]", "").toLowerCase();
        int left = 0, right = cleaned.length() - 1;
        while (left < right) {
            if (cleaned.charAt(left) != cleaned.charAt(right)) {
                return false;
            }
            left++;
            right--;
        }
        return true;
    }

    public static boolean isPalindromeRecursive(String text) {
        if (text == null) return false;
        String cleaned = text.replaceAll("[^a-zA-Z0-9]", "").toLowerCase();
        return isPalindromeRecursiveHelper(cleaned, 0, cleaned.length() - 1);
    }

    private static boolean isPalindromeRecursiveHelper(String s, int left, int right) {
        if (left >= right) return true;
        if (s.charAt(left) != s.charAt(right)) return false;
        return isPalindromeRecursiveHelper(s, left + 1, right - 1);
    }

    public static boolean isPalindromeArrayReversal(String text) {
        if (text == null) return false;
        String cleaned = text.replaceAll("[^a-zA-Z0-9]", "").toLowerCase();
        char[] chars = cleaned.toCharArray();
        char[] reversed = new char[chars.length];
        for (int i = 0; i < chars.length; i++) {
            reversed[i] = chars[chars.length - 1 - i];
        }
        return new String(chars).equals(new String(reversed));
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter a word or phrase: ");
        String input = scanner.nextLine();

        boolean iter = isPalindromeIterative(input);
        boolean rec = isPalindromeRecursive(input);
        boolean arr = isPalindromeArrayReversal(input);

        System.out.println("\nInput: \"" + input + "\"");
        System.out.println("Iterative: " + (iter ? "Palindrome" : "Not Palindrome"));
        System.out.println("Recursive: " + (rec ? "Palindrome" : "Not Palindrome"));
        System.out.println("Array Reversal: " + (arr ? "Palindrome" : "Not Palindrome"));
        System.out.println("\nAll three agree: " + (iter == rec && rec == arr ? "Yes" : "No"));

        scanner.close();
    }
}