import java.util.Scanner;

abstract class TravelBooking {
    private static final double BOOKING_FEE = 50.0;
    protected double distanceKm;

    public TravelBooking(double distanceKm) {
        this.distanceKm = distanceKm;
    }

    public abstract double calculateBaseFare();

    public double calculateTotal() {
        return calculateBaseFare() + BOOKING_FEE;
    }

    public abstract String getMode();
}

class BusBooking extends TravelBooking {
    public BusBooking(double distanceKm) {
        super(distanceKm);
    }

    @Override
    public double calculateBaseFare() {
        return distanceKm * 2.0;
    }

    @Override
    public String getMode() {
        return "BUS";
    }
}

class TrainBooking extends TravelBooking {
    public TrainBooking(double distanceKm) {
        super(distanceKm);
    }

    @Override
    public double calculateBaseFare() {
        return distanceKm * 1.5;
    }

    @Override
    public String getMode() {
        return "TRAIN";
    }
}

class FlightBooking extends TravelBooking {
    public FlightBooking(double distanceKm) {
        super(distanceKm);
    }

    @Override
    public double calculateBaseFare() {
        return 2500.0 + distanceKm * 4.0;
    }

    @Override
    public String getMode() {
        return "FLIGHT";
    }
}

public class TravelBookingMain {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();

        for (int i = 0; i < n; i++) {
            String mode = scanner.next();
            double distance = scanner.nextDouble();

            TravelBooking booking = createBooking(mode, distance);
            double total = booking.calculateTotal();
            System.out.printf("%s: %.2f%n", booking.getMode(), total);
        }
        scanner.close();
    }

    private static TravelBooking createBooking(String mode, double distance) {
        switch (mode) {
            case "BUS":
                return new BusBooking(distance);
            case "TRAIN":
                return new TrainBooking(distance);
            case "FLIGHT":
                return new FlightBooking(distance);
            default:
                throw new IllegalArgumentException("Unknown travel mode: " + mode);
        }
    }
}