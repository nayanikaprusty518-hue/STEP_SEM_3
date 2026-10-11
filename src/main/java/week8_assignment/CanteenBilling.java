import java.util.Scanner;

abstract class Customer {
    protected double amount;

    public Customer(double amount) {
        this.amount = amount;
    }

    public abstract double calculateFinalAmount();

    public abstract String getType();
}

class Student extends Customer {
    public Student(double amount) {
        super(amount);
    }

    @Override
    public double calculateFinalAmount() {
        return amount * 0.90;
    }

    @Override
    public String getType() {
        return "STUDENT";
    }
}

class Staff extends Customer {
    public Staff(double amount) {
        super(amount);
    }

    @Override
    public double calculateFinalAmount() {
        return amount * 0.95;
    }

    @Override
    public String getType() {
        return "STAFF";
    }
}

class Guest extends Customer {
    public Guest(double amount) {
        super(amount);
    }

    @Override
    public double calculateFinalAmount() {
        return amount + 10;
    }

    @Override
    public String getType() {
        return "GUEST";
    }
}

public class CanteenBilling {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();

        double total = 0;
        for (int i = 0; i < n; i++) {
            String type = scanner.next();
            double amount = scanner.nextDouble();

            Customer customer = createCustomer(type, amount);
            double finalAmount = customer.calculateFinalAmount();
            total += finalAmount;

            System.out.printf("%s: %.2f%n", customer.getType(), finalAmount);
        }
        System.out.printf("Total: %.2f%n", total);
        scanner.close();
    }

    private static Customer createCustomer(String type, double amount) {
        switch (type) {
            case "STUDENT":
                return new Student(amount);
            case "STAFF":
                return new Staff(amount);
            case "GUEST":
                return new Guest(amount);
            default:
                throw new IllegalArgumentException("Unknown customer type: " + type);
        }
    }
}