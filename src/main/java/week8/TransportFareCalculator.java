import java.util.Scanner;

abstract class Transport {
    protected double distance;

    public Transport(double distance) {
        this.distance = distance;
    }

    public abstract double calculateFare();

    public abstract String getType();
}

class Bus extends Transport {
    public Bus(double distance) {
        super(distance);
    }

    @Override
    public double calculateFare() {
        double fare = 2.0 + (0.10 * distance);
        return Math.min(fare, 10.0);
    }

    @Override
    public String getType() {
        return "BUS";
    }
}

class Train extends Transport {
    public Train(double distance) {
        super(distance);
    }

    @Override
    public double calculateFare() {
        return 3.0 + (0.15 * distance);
    }

    @Override
    public String getType() {
        return "TRAIN";
    }
}

class Metro extends Transport {
    private double peakHourFactor;

    public Metro(double distance, double peakHourFactor) {
        super(distance);
        this.peakHourFactor = peakHourFactor;
    }

    @Override
    public double calculateFare() {
        return (1.50 + (0.20 * distance)) * peakHourFactor;
    }

    @Override
    public String getType() {
        return "METRO";
    }
}

public class TransportFareCalculator {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();

        double total = 0;
        for (int i = 0; i < n; i++) {
            String type = scanner.next();
            Transport transport;

            if (type.equals("BUS")) {
                double distance = scanner.nextDouble();
                transport = new Bus(distance);
            } else if (type.equals("TRAIN")) {
                double distance = scanner.nextDouble();
                transport = new Train(distance);
            } else if (type.equals("METRO")) {
                double distance = scanner.nextDouble();
                double peakHourFactor = scanner.nextDouble();
                transport = new Metro(distance, peakHourFactor);
            } else {
                throw new IllegalArgumentException("Unknown transport type: " + type);
            }

            double fare = transport.calculateFare();
            total += fare;
            System.out.printf("%s: %.2f%n", transport.getType(), fare);
        }
        System.out.printf("Total: %.2f%n", total);
        scanner.close();
    }
}