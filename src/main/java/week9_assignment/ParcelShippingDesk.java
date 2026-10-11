import java.util.Scanner;

abstract class Parcel {
    protected double weightKg;
    protected double declaredValue;

    public Parcel(double weightKg, double declaredValue) {
        this.weightKg = weightKg;
        this.declaredValue = declaredValue;
    }

    public abstract double calculateCharge();

    public double calculateInsurance() {
        return 0.0;
    }

    public double calculateTotal() {
        return calculateCharge() + calculateInsurance();
    }

    public abstract String getType();
}

class StandardParcel extends Parcel {
    public StandardParcel(double weightKg, double declaredValue) {
        super(weightKg, declaredValue);
    }

    @Override
    public double calculateCharge() {
        return 40.0 + 10.0 * weightKg;
    }

    @Override
    public String getType() {
        return "STANDARD";
    }
}

class ExpressParcel extends Parcel {
    public ExpressParcel(double weightKg, double declaredValue) {
        super(weightKg, declaredValue);
    }

    @Override
    public double calculateCharge() {
        return 80.0 + 15.0 * weightKg;
    }

    @Override
    public double calculateInsurance() {
        return declaredValue * 0.02;
    }

    @Override
    public String getType() {
        return "EXPRESS";
    }
}

class FragileParcel extends Parcel {
    public FragileParcel(double weightKg, double declaredValue) {
        super(weightKg, declaredValue);
    }

    @Override
    public double calculateCharge() {
        return (40.0 + 10.0 * weightKg) + 50.0;
    }

    @Override
    public double calculateInsurance() {
        return declaredValue * 0.02;
    }

    @Override
    public String getType() {
        return "FRAGILE";
    }
}

public class ParcelShippingDesk {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();

        double grandTotal = 0;
        for (int i = 0; i < n; i++) {
            String type = scanner.next();
            double weight = scanner.nextDouble();
            double value = scanner.nextDouble();

            Parcel parcel = createParcel(type, weight, value);
            double charge = parcel.calculateCharge();
            double insurance = parcel.calculateInsurance();
            double total = parcel.calculateTotal();
            grandTotal += total;

            System.out.printf("%s: Charge=%.2f Insurance=%.2f Total=%.2f%n",
                    parcel.getType(), charge, insurance, total);
        }
        System.out.printf("Grand Total: %.2f%n", grandTotal);
        scanner.close();
    }

    private static Parcel createParcel(String type, double weight, double value) {
        switch (type) {
            case "STANDARD":
                return new StandardParcel(weight, value);
            case "EXPRESS":
                return new ExpressParcel(weight, value);
            case "FRAGILE":
                return new FragileParcel(weight, value);
            default:
                throw new IllegalArgumentException("Unknown parcel type: " + type);
        }
    }
}