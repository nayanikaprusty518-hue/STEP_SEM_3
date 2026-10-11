import java.util.Scanner;

abstract class Cab {
    private static final double MINIMUM_FARE = 100.0;
    protected double distanceKm;

    public Cab(double distanceKm) {
        this.distanceKm = distanceKm;
    }

    public abstract double getRatePerKm();

    public abstract boolean offersNightService();

    public double calculateBaseFare() {
        double fare = distanceKm * getRatePerKm();
        return Math.max(fare, MINIMUM_FARE);
    }

    public String getType() {
        String className = getClass().getSimpleName();
        return className.replace("Cab", "").toUpperCase();
    }
}

class MiniCab extends Cab {
    public MiniCab(double distanceKm) {
        super(distanceKm);
    }

    @Override
    public double getRatePerKm() {
        return 10.0;
    }

    @Override
    public boolean offersNightService() {
        return false;
    }
}

class SedanCab extends Cab {
    public SedanCab(double distanceKm) {
        super(distanceKm);
    }

    @Override
    public double getRatePerKm() {
        return 14.0;
    }

    @Override
    public boolean offersNightService() {
        return true;
    }
}

class SUVCab extends Cab {
    public SUVCab(double distanceKm) {
        super(distanceKm);
    }

    @Override
    public double getRatePerKm() {
        return 18.0;
    }

    @Override
    public boolean offersNightService() {
        return true;
    }
}

public class CityCabFareMeter {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();

        double total = 0;
        for (int i = 0; i < n; i++) {
            String cabType = scanner.next();
            double distance = scanner.nextDouble();
            String time = scanner.next();

            Cab cab = createCab(cabType, distance);

            if (time.equals("NIGHT")) {
                if (!cab.offersNightService()) {
                    System.out.printf("%s: night service not available%n", cab.getType());
                    continue;
                }
                double fare = cab.calculateBaseFare() * 1.2;
                total += fare;
                System.out.printf("%s: %.2f%n", cab.getType(), fare);
            } else {
                double fare = cab.calculateBaseFare();
                total += fare;
                System.out.printf("%s: %.2f%n", cab.getType(), fare);
            }
        }
        System.out.printf("Total: %.2f%n", total);
        scanner.close();
    }

    private static Cab createCab(String type, double distance) {
        switch (type) {
            case "MINI":
                return new MiniCab(distance);
            case "SEDAN":
                return new SedanCab(distance);
            case "SUV":
                return new SUVCab(distance);
            default:
                throw new IllegalArgumentException("Unknown cab type: " + type);
        }
    }
}