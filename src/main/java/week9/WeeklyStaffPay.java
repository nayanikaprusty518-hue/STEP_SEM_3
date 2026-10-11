import java.util.Scanner;

abstract class StaffMember {
    protected String name;

    public StaffMember(String name) {
        this.name = name;
    }

    public abstract double calculatePay();

    public String getName() {
        return name;
    }
}

class FullTimeStaff extends StaffMember {
    private double weeklySalary;

    public FullTimeStaff(String name, double weeklySalary) {
        super(name);
        this.weeklySalary = weeklySalary;
    }

    @Override
    public double calculatePay() {
        return weeklySalary;
    }
}

class HourlyStaff extends StaffMember {
    private int hours;
    private double rate;

    public HourlyStaff(String name, int hours, double rate) {
        super(name);
        this.hours = hours;
        this.rate = rate;
    }

    @Override
    public double calculatePay() {
        if (hours <= 40) {
            return hours * rate;
        } else {
            return 40 * rate + (hours - 40) * rate * 1.5;
        }
    }
}

class Intern extends StaffMember {
    private double stipend;

    public Intern(String name, double stipend) {
        super(name);
        this.stipend = stipend;
    }

    @Override
    public double calculatePay() {
        return stipend;
    }
}

public class WeeklyStaffPay {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();

        double totalPayroll = 0;
        for (int i = 0; i < n; i++) {
            String type = scanner.next();
            String name = scanner.next();
            StaffMember staff = createStaff(type, name, scanner);
            double pay = staff.calculatePay();
            totalPayroll += pay;
            System.out.printf("%s: %.2f%n", staff.getName(), pay);
        }
        System.out.printf("Total Payroll: %.2f%n", totalPayroll);
        scanner.close();
    }

    private static StaffMember createStaff(String type, String name, Scanner scanner) {
        switch (type) {
            case "FULLTIME":
                double salary = scanner.nextDouble();
                return new FullTimeStaff(name, salary);
            case "HOURLY":
                int hours = scanner.nextInt();
                double rate = scanner.nextDouble();
                return new HourlyStaff(name, hours, rate);
            case "INTERN":
                double stipend = scanner.nextDouble();
                return new Intern(name, stipend);
            default:
                throw new IllegalArgumentException("Unknown staff type: " + type);
        }
    }
}