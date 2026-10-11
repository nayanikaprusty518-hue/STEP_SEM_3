import java.util.Scanner;

abstract class Vehicle {
    protected int hours;

    public Vehicle(int hours) {
        this.hours = hours;
    }

    public abstract double calculateCharge();

    public abstract String getType();
}

class Bike extends Vehicle {
    public Bike(int hours) {
        super(hours);
    }

    @Override
    public double calculateCharge() {
        return 10.0 * hours;
    }

    @Override
    public String getType() {
        return "BIKE";
    }
}

class Car extends Vehicle {
    public Car(int hours) {
        super(hours);
    }

    @Override
    public double calculateCharge() {
        if (hours <= 1) {
            return 30.0;
        } else {
            return 30.0 + 20.0 * (hours - 1);
        }
    }

    @Override
    public String getType() {
        return "CAR";
    }
}

class Truck extends Vehicle {
    public Truck(int hours) {
        super(hours);
    }

    @Override
    public double calculateCharge() {
        double charge = 50.0 * hours;
        return Math.max(charge, 100.0);
    }

    @Override
    public String getType() {
        return "TRUCK";
    }
}

public class ParkingChargeCalculator {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();

        double total = 0;
        for (int i = 0; i < n; i++) {
            String type = scanner.next();
            int hours = scanner.nextInt();

            Vehicle vehicle = createVehicle(type, hours);
            double charge = vehicle.calculateCharge();
            total += charge;

            System.out.printf("%s: %.2f%n", vehicle.getType(), charge);
        }
        System.out.printf("Total: %.2f%n", total);
        scanner.close();
    }

    private static Vehicle createVehicle(String type, int hours) {
        switch (type) {
            case "BIKE":
                return new Bike(hours);
            case "CAR":
                return new Car(hours);
            case "TRUCK":
                return new Truck(hours);
            default:
                throw new IllegalArgumentException("Unknown vehicle type: " + type);
        }
    }
}