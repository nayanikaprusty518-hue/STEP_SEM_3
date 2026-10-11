public class PiggyBank {
    private int savings;
    private final String id;

    public PiggyBank(String id) {
        this.id = id;
        this.savings = 0;
    }

    public void deposit(int amount) {
        if (amount > 0) {
            savings += amount;
        }
    }

    public void withdraw(int amount) {
        if (amount > 0 && amount <= savings) {
            savings -= amount;
        }
    }

    public int getSavings() {
        return savings;
    }

    public String getId() {
        return id;
    }

    public static void main(String[] args) {
        PiggyBank pb = new PiggyBank("PB-1");
        pb.deposit(100);
        System.out.println("After deposit(100): savings = " + pb.getSavings());
        pb.withdraw(30);
        System.out.println("After withdraw(30): savings = " + pb.getSavings());
        pb.withdraw(500);
        System.out.println("After withdraw(500): savings = " + pb.getSavings());
    }
}