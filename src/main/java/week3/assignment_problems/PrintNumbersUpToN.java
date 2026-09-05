package week3.assignment_problems;

public class PrintNumbersUpToN {
    public static void printNumbersUpToN(int n) {
        for (int i = 1; i <= n; i++) {
            System.out.print(i + " ");
        }
        System.out.println();
    }

    public static void main(String[] args) {
        System.out.print("Test 1: ");
        printNumbersUpToN(5);
    }
}