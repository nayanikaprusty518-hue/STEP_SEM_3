import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

abstract class Plan {
    protected String name;
    protected LocalDate startDate;

    public Plan(String name, LocalDate startDate) {
        this.name = name;
        this.startDate = startDate;
    }

    public abstract int getValidityDays();

    public String getName() {
        return name;
    }

    public LocalDate getRenewalDate() {
        return startDate.plusDays(getValidityDays());
    }
}

class BasicPlan extends Plan {
    public BasicPlan(String name, LocalDate startDate) {
        super(name, startDate);
    }

    @Override
    public int getValidityDays() {
        return 30;
    }
}

class StandardPlan extends Plan {
    public StandardPlan(String name, LocalDate startDate) {
        super(name, startDate);
    }

    @Override
    public int getValidityDays() {
        return 90;
    }
}

class PremiumPlan extends Plan {
    public PremiumPlan(String name, LocalDate startDate) {
        super(name, startDate);
    }

    @Override
    public int getValidityDays() {
        return 365;
    }
}

public class StreamingPlanRenewal {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");

        for (int i = 0; i < n; i++) {
            String type = scanner.next();
            String name = scanner.next();
            String dateStr = scanner.next();

            LocalDate startDate = LocalDate.parse(dateStr, formatter);
            Plan plan = createPlan(type, name, startDate);
            LocalDate renewalDate = plan.getRenewalDate();

            System.out.println(plan.getName() + ": " + renewalDate.format(formatter));
        }
        scanner.close();
    }

    private static Plan createPlan(String type, String name, LocalDate startDate) {
        switch (type) {
            case "BASIC":
                return new BasicPlan(name, startDate);
            case "STANDARD":
                return new StandardPlan(name, startDate);
            case "PREMIUM":
                return new PremiumPlan(name, startDate);
            default:
                throw new IllegalArgumentException("Unknown plan type: " + type);
        }
    }
}