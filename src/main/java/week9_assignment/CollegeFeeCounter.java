import java.util.Scanner;

abstract class Student {
    private static final double TRANSPORT_FEE = 12000.0;
    protected String name;

    public Student(String name) {
        this.name = name;
    }

    public abstract double calculateTuition();

    public abstract boolean usesBus();

    public double calculateTotalFee() {
        double fee = calculateTuition();
        if (usesBus()) {
            fee += TRANSPORT_FEE;
        }
        return fee;
    }

    public String getName() {
        return name;
    }
}

class DayScholar extends Student {
    public DayScholar(String name) {
        super(name);
    }

    @Override
    public double calculateTuition() {
        return 40000.0;
    }

    @Override
    public boolean usesBus() {
        return true;
    }
}

class Hosteller extends Student {
    public Hosteller(String name) {
        super(name);
    }

    @Override
    public double calculateTuition() {
        return 40000.0 + 60000.0;
    }

    @Override
    public boolean usesBus() {
        return false;
    }
}

class Scholar extends Student {
    public Scholar(String name) {
        super(name);
    }

    @Override
    public double calculateTuition() {
        return 20000.0;
    }

    @Override
    public boolean usesBus() {
        return true;
    }
}

public class CollegeFeeCounter {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();

        double totalCollected = 0;
        for (int i = 0; i < n; i++) {
            String type = scanner.next();
            String name = scanner.next();

            Student student = createStudent(type, name);
            double fee = student.calculateTotalFee();
            totalCollected += fee;
            System.out.printf("%s: %.2f%n", student.getName(), fee);
        }
        System.out.printf("Total Collected: %.2f%n", totalCollected);
        scanner.close();
    }

    private static Student createStudent(String type, String name) {
        switch (type) {
            case "DAY_SCHOLAR":
                return new DayScholar(name);
            case "HOSTELLER":
                return new Hosteller(name);
            case "SCHOLAR":
                return new Scholar(name);
            default:
                throw new IllegalArgumentException("Unknown student type: " + type);
        }
    }
}