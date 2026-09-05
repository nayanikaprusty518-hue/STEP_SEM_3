package week3.assignment_problems;

public class PositiveNegativeZeroClassifier {
    public static void classifyNumber(int number) {
        if (number > 0) {
            System.out.println("Positive");
        } else if (number < 0) {
            System.out.println("Negative");
        } else {
            System.out.println("Zero");
        }
    }

    public static void main(String[] args) {
        System.out.print("Test 1: ");
        classifyNumber(15);
        System.out.print("Test 2: ");
        classifyNumber(-4);
        System.out.print("Test 3: ");
        classifyNumber(0);
    }
}