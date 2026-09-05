package week3.assignment_problems;

public class NumberPyramidPatternPrinter {
    public static void printNumberPyramid(int n) {
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= i; j++) {
                System.out.print(i + " ");
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {
        System.out.println("Test 1:");
        printNumberPyramid(4);
    }
}