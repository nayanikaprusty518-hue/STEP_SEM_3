package week1.assignment_problems;

public class TypingSpeedTestAccuracyChecker {
    public static void checkTypingAccuracy(String original, String typed) {
        if (original == null || typed == null) {
            System.out.println("Invalid input: strings cannot be null");
            return;
        }
        if (original.length() != typed.length()) {
            System.out.println("Error: Strings must be of equal length");
            return;
        }

        int matched = 0;
        int firstMismatchPos = -1;
        char origChar = 0, typedChar = 0;

        for (int i = 0; i < original.length(); i++) {
            if (original.charAt(i) == typed.charAt(i)) {
                matched++;
            } else if (firstMismatchPos == -1) {
                firstMismatchPos = i + 1;
                origChar = original.charAt(i);
                typedChar = typed.charAt(i);
            }
        }

        double accuracy = (double) matched / original.length() * 100;

        System.out.print("Matched: " + matched + "/" + original.length() + " | Accuracy: " + String.format("%.2f", accuracy) + "%");
        if (firstMismatchPos == -1) {
            System.out.println(" | No Mismatches");
        } else {
            System.out.println(" | First Mismatch at position " + firstMismatchPos + " ('" + origChar + "' vs '" + typedChar + "')");
        }
    }

    public static void main(String[] args) {
        System.out.print("Test 1: ");
        checkTypingAccuracy("hello world", "hello worlt");

        System.out.print("Test 2: ");
        checkTypingAccuracy("coding", "coding");
    }
}