package week3.assignment_problems;

public class MultiplicationTableGeneratorWithInputValidation {
    public static void generateFirstValidTable(int[] candidates) {
        for (int candidate : candidates) {
            if (candidate < 1) {
                System.out.println("Skipping invalid number: " + candidate);
                continue;
            }
            
            for (int i = 1; i <= 10; i++) {
                System.out.println(candidate + " x " + i + " = " + (candidate * i));
            }
            break;
        }
    }

    public static void main(String[] args) {
        System.out.println("Test 1:");
        generateFirstValidTable(new int[]{-3, 0, 7, 9});
    }
}