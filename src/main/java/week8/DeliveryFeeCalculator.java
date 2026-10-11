import java.util.Scanner;

abstract class Delivery {
    protected double weight;
    protected double distance;

    public Delivery(double weight, double distance) {
        this.weight = weight;
        this.distance = distance;
    }

    public abstract double calculateFee();

    public abstract String getType();
}

class StandardDelivery extends Delivery {
    public StandardDelivery(double weight, double distance) {
        super(weight, distance);
    }

    @Override
    public double calculateFee() {
        return 5.0 + (0.50 * weight) + (0.10 * distance);
    }

    @Override
    public String getType() {
        return "STANDARD";
    }
}

class ExpressDelivery extends Delivery {
    public ExpressDelivery(double weight, double distance) {
        super(weight, distance);
    }

    @Override
    public double calculateFee() {
        return 15.0 + (1.00 * weight) + (0.20 * distance);
    }

    @Override
    public String getType() {
        return "EXPRESS";
    }
}

class InternationalDelivery extends Delivery {
    private double customsFee;

    public InternationalDelivery(double weight, double distance, double customsFee) {
        super(weight, distance);
        this.customsFee = customsFee;
    }

    @Override
    public double calculateFee() {
        return 25.0 + (2.00 * weight) + (0.50 * distance) + customsFee;
    }

    @Override
    public String getType() {
        return "INTERNATIONAL";
    }
}

public class DeliveryFeeCalculator {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();

        double total = 0;
        for (int i = 0; i < n; i++) {
            String type = scanner.next();
            Delivery delivery;

            if (type.equals("STANDARD")) {
                double weight = scanner.nextDouble();
                double distance = scanner.nextDouble();
                delivery = new StandardDelivery(weight, distance);
            } else if (type.equals("EXPRESS")) {
                double weight = scanner.nextDouble();
                double distance = scanner.nextDouble();
                delivery = new ExpressDelivery(weight, distance);
            } else if (type.equals("INTERNATIONAL")) {
                double weight = scanner.nextDouble();
                double distance = scanner.nextDouble();
                double customsFee = scanner.nextDouble();
                delivery = new InternationalDelivery(weight, distance, customsFee);
            } else {
                throw new IllegalArgumentException("Unknown delivery type: " + type);
            }

            double fee = delivery.calculateFee();
            total += fee;
            System.out.printf("%s: %.2f%n", delivery.getType(), fee);
        }
        System.out.printf("Total: %.2f%n", total);
        scanner.close();
    }
}