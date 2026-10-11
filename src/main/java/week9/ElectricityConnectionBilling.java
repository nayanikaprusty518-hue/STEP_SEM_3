import java.util.Scanner;

abstract class Connection {
    protected int units;

    public Connection(int units) {
        this.units = units;
    }

    public abstract double calculateBill();

    public abstract String getType();
}

class HomeConnection extends Connection {
    public HomeConnection(int units) {
        super(units);
    }

    @Override
    public double calculateBill() {
        if (units <= 100) {
            return units * 5.0;
        } else {
            return 100 * 5.0 + (units - 100) * 7.0;
        }
    }

    @Override
    public String getType() {
        return "HOME";
    }
}

class ShopConnection extends Connection {
    public ShopConnection(int units) {
        super(units);
    }

    @Override
    public double calculateBill() {
        return units * 8.0 + 100.0;
    }

    @Override
    public String getType() {
        return "SHOP";
    }
}

class FactoryConnection extends Connection {
    public FactoryConnection(int units) {
        super(units);
    }

    @Override
    public double calculateBill() {
        double bill = units * 6.0;
        return Math.max(bill, 1000.0);
    }

    @Override
    public String getType() {
        return "FACTORY";
    }
}

public class ElectricityConnectionBilling {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();

        double total = 0;
        for (int i = 0; i < n; i++) {
            String type = scanner.next();
            int units = scanner.nextInt();

            Connection connection = createConnection(type, units);
            double bill = connection.calculateBill();
            total += bill;
            System.out.printf("%s: %.2f%n", connection.getType(), bill);
        }
        System.out.printf("Total: %.2f%n", total);
        scanner.close();
    }

    private static Connection createConnection(String type, int units) {
        switch (type) {
            case "HOME":
                return new HomeConnection(units);
            case "SHOP":
                return new ShopConnection(units);
            case "FACTORY":
                return new FactoryConnection(units);
            default:
                throw new IllegalArgumentException("Unknown connection type: " + type);
        }
    }
}