import java.util.Random;

public class BMICalculator {
    public static String getBmiStatus(double bmi) {
        if (bmi < 18.5) return "Underweight";
        else if (bmi < 25) return "Normal";
        else if (bmi < 30) return "Overweight";
        else return "Obese";
    }

    public static void printWellnessReport(double[] heights, double[] weights) {
        if (heights.length != weights.length) {
            System.out.println("Error: Heights and weights arrays must have the same length.");
            return;
        }

        System.out.println("Corporate Wellness Report");
        System.out.println("=================================================================");
        System.out.printf("%-8s %-15s %-15s %-10s %s%n", "Person", "Height (m)", "Weight (kg)", "BMI", "Status");
        System.out.println("-----------------------------------------------------------------");

        for (int i = 0; i < heights.length; i++) {
            double bmi = weights[i] / (heights[i] * heights[i]);
            String status = getBmiStatus(bmi);
            System.out.printf("%-8d %-15.2f %-15.1f %-10.2f %s%n", 
                i + 1, heights[i], weights[i], bmi, status);
        }
        System.out.println("=================================================================");
    }

    public static void main(String[] args) {
        int teamSize = 10;
        double[] heights = new double[teamSize];
        double[] weights = new double[teamSize];
        Random random = new Random();

        for (int i = 0; i < teamSize; i++) {
            heights[i] = 1.5 + random.nextDouble() * 0.5;
            weights[i] = 50 + random.nextDouble() * 50;
        }

        printWellnessReport(heights, weights);
    }
}