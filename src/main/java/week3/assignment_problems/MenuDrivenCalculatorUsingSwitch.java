package week3.assignment_problems;

public class MenuDrivenCalculatorUsingSwitch {
    public static void calculate(double a, double b, char operator) {
        switch (operator) {
            case '+':
                System.out.println("Result: " + (a + b));
                break;
            case '-':
                System.out.println("Result: " + (a - b));
                break;
            case '*':
                System.out.println("Result: " + (a * b));
                break;
            case '/':
                if (b == 0) {
                    System.out.println("Cannot divide by zero");
                } else {
                    System.out.println("Result: " + (a / b));
                }
                break;
            default:
                System.out.println("Invalid operator");
                break;
        }
    }

    public static void main(String[] args) {
        System.out.print("Test 1: ");
        calculate(10, 4, '+');
        System.out.print("Test 2: ");
        calculate(10, 0, '/');
        System.out.print("Test 3: ");
        calculate(10, 4, '%');
    }
}