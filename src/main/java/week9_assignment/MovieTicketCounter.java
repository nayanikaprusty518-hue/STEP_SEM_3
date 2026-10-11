import java.util.Scanner;

abstract class Ticket {
    private static final double CONVENIENCE_FEE = 20.0;
    protected int count;

    public Ticket(int count) {
        this.count = count;
    }

    public abstract double getPricePerTicket();

    public double calculateAmount() {
        return count * (getPricePerTicket() + CONVENIENCE_FEE);
    }

    public abstract String getSeatType();
}

class RegularTicket extends Ticket {
    public RegularTicket(int count) {
        super(count);
    }

    @Override
    public double getPricePerTicket() {
        return 150.0;
    }

    @Override
    public String getSeatType() {
        return "REGULAR";
    }
}

class PremiumTicket extends Ticket {
    public PremiumTicket(int count) {
        super(count);
    }

    @Override
    public double getPricePerTicket() {
        return 250.0;
    }

    @Override
    public String getSeatType() {
        return "PREMIUM";
    }
}

class ReclinerTicket extends Ticket {
    public ReclinerTicket(int count) {
        super(count);
    }

    @Override
    public double getPricePerTicket() {
        return 400.0;
    }

    @Override
    public String getSeatType() {
        return "RECLINER";
    }
}

public class MovieTicketCounter {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();

        double total = 0;
        for (int i = 0; i < n; i++) {
            String type = scanner.next();
            int count = scanner.nextInt();

            Ticket ticket = createTicket(type, count);
            double amount = ticket.calculateAmount();
            total += amount;
            System.out.printf("%s: %.2f%n", ticket.getSeatType(), amount);
        }
        System.out.printf("Total: %.2f%n", total);
        scanner.close();
    }

    private static Ticket createTicket(String type, int count) {
        switch (type) {
            case "REGULAR":
                return new RegularTicket(count);
            case "PREMIUM":
                return new PremiumTicket(count);
            case "RECLINER":
                return new ReclinerTicket(count);
            default:
                throw new IllegalArgumentException("Unknown seat type: " + type);
        }
    }
}