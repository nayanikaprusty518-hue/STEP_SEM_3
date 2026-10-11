import java.util.Scanner;

abstract class LibraryItem {
    protected String title;
    protected int daysLate;

    public LibraryItem(String title, int daysLate) {
        this.title = title;
        this.daysLate = daysLate;
    }

    public abstract double calculateFine();

    public String getTitle() {
        return title;
    }
}

class Book extends LibraryItem {
    public Book(String title, int daysLate) {
        super(title, daysLate);
    }

    @Override
    public double calculateFine() {
        return daysLate * 2.0;
    }
}

class DVD extends LibraryItem {
    public DVD(String title, int daysLate) {
        super(title, daysLate);
    }

    @Override
    public double calculateFine() {
        double fine = daysLate * 5.0;
        return Math.min(fine, 50.0);
    }
}

class Magazine extends LibraryItem {
    public Magazine(String title, int daysLate) {
        super(title, daysLate);
    }

    @Override
    public double calculateFine() {
        return daysLate * 1.0;
    }
}

public class LibraryLateFineCounter {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();

        double totalFines = 0;
        for (int i = 0; i < n; i++) {
            String type = scanner.next();
            String title = scanner.next();
            int daysLate = scanner.nextInt();

            LibraryItem item = createItem(type, title, daysLate);
            double fine = item.calculateFine();
            totalFines += fine;
            System.out.printf("%s: %.2f%n", item.getTitle(), fine);
        }
        System.out.printf("Total Fines: %.2f%n", totalFines);
        scanner.close();
    }

    private static LibraryItem createItem(String type, String title, int daysLate) {
        switch (type) {
            case "BOOK":
                return new Book(title, daysLate);
            case "DVD":
                return new DVD(title, daysLate);
            case "MAGAZINE":
                return new Magazine(title, daysLate);
            default:
                throw new IllegalArgumentException("Unknown item type: " + type);
        }
    }
}