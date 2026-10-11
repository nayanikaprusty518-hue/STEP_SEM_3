import java.util.Scanner;

abstract class Room {
    protected int units;

    public Room(int units) {
        this.units = units;
    }

    public abstract double calculateBill();

    public abstract String getType();
}

class SingleRoom extends Room {
    public SingleRoom(int units) {
        super(units);
    }

    @Override
    public double calculateBill() {
        return units * 8.0;
    }

    @Override
    public String getType() {
        return "SINGLE";
    }
}

class SharedRoom extends Room {
    private int occupants;

    public SharedRoom(int units, int occupants) {
        super(units);
        this.occupants = occupants;
    }

    @Override
    public double calculateBill() {
        return (units * 6.0) / occupants;
    }

    @Override
    public String getType() {
        return "SHARED";
    }
}

class ACRoom extends Room {
    public ACRoom(int units) {
        super(units);
    }

    @Override
    public double calculateBill() {
        return units * 10.0 + 200.0;
    }

    @Override
    public String getType() {
        return "AC";
    }
}

public class ElectricityBillCalculator {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();

        double total = 0;
        for (int i = 0; i < n; i++) {
            String type = scanner.next();
            Room room;

            if (type.equals("SINGLE")) {
                int units = scanner.nextInt();
                room = new SingleRoom(units);
            } else if (type.equals("SHARED")) {
                int units = scanner.nextInt();
                int occupants = scanner.nextInt();
                room = new SharedRoom(units, occupants);
            } else if (type.equals("AC")) {
                int units = scanner.nextInt();
                room = new ACRoom(units);
            } else {
                throw new IllegalArgumentException("Unknown room type: " + type);
            }

            double bill = room.calculateBill();
            total += bill;
            System.out.printf("%s: %.2f%n", room.getType(), bill);
        }
        System.out.printf("Total: %.2f%n", total);
        scanner.close();
    }
}