import java.util.Scanner;

abstract class Appliance {
    protected int hoursUsed;

    public Appliance(int hoursUsed) {
        this.hoursUsed = hoursUsed;
    }

    public abstract int getPowerRating();

    public abstract boolean supportsSaverMode();

    public double calculateUnits(boolean saverMode) {
        if (saverMode && !supportsSaverMode()) {
            return -1;
        }
        double units = (getPowerRating() * hoursUsed) / 1000.0;
        if (saverMode) {
            units *= 0.75;
        }
        return units;
    }

    public double calculateCost(boolean saverMode) {
        double units = calculateUnits(saverMode);
        if (units < 0) {
            return -1;
        }
        return units * 8.0;
    }

    public abstract String getType();
}

class Fridge extends Appliance {
    public Fridge(int hoursUsed) {
        super(hoursUsed);
    }

    @Override
    public int getPowerRating() {
        return 150;
    }

    @Override
    public boolean supportsSaverMode() {
        return false;
    }

    @Override
    public String getType() {
        return "FRIDGE";
    }
}

class AC extends Appliance {
    public AC(int hoursUsed) {
        super(hoursUsed);
    }

    @Override
    public int getPowerRating() {
        return 1500;
    }

    @Override
    public boolean supportsSaverMode() {
        return true;
    }

    @Override
    public String getType() {
        return "AC";
    }
}

class TV extends Appliance {
    public TV(int hoursUsed) {
        super(hoursUsed);
    }

    @Override
    public int getPowerRating() {
        return 100;
    }

    @Override
    public boolean supportsSaverMode() {
        return false;
    }

    @Override
    public String getType() {
        return "TV";
    }
}

class Washer extends Appliance {
    public Washer(int hoursUsed) {
        super(hoursUsed);
    }

    @Override
    public int getPowerRating() {
        return 500;
    }

    @Override
    public boolean supportsSaverMode() {
        return true;
    }

    @Override
    public String getType() {
        return "WASHER";
    }
}

public class HomeApplianceEnergyReport {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();

        double totalCost = 0;
        for (int i = 0; i < n; i++) {
            String type = scanner.next();
            int hours = scanner.nextInt();
            boolean saverMode = scanner.hasNext("SAVER");
            if (saverMode) {
                scanner.next();
            }

            Appliance appliance = createAppliance(type, hours);
            double units = appliance.calculateUnits(saverMode);

            if (units < 0) {
                System.out.printf("%s: saver mode not supported%n", appliance.getType());
            } else {
                double cost = appliance.calculateCost(saverMode);
                totalCost += cost;
                System.out.printf("%s: Units=%.2f Cost=%.2f%n", appliance.getType(), units, cost);
            }
        }
        System.out.printf("Total Cost: %.2f%n", totalCost);
        scanner.close();
    }

    private static Appliance createAppliance(String type, int hours) {
        switch (type) {
            case "FRIDGE":
                return new Fridge(hours);
            case "AC":
                return new AC(hours);
            case "TV":
                return new TV(hours);
            case "WASHER":
                return new Washer(hours);
            default:
                throw new IllegalArgumentException("Unknown appliance type: " + type);
        }
    }
}