package week3.assignment_problems;

public class ATMPINRetrySystem {
    public static void atmPinRetry(String correctPin, String[] attempts) {
        int attemptCounter = 0;
        boolean success = false;
        
        while (attemptCounter < attempts.length && !success) {
            if (attempts[attemptCounter].equals(correctPin)) {
                success = true;
                System.out.println("PIN accepted");
            }
            attemptCounter++;
        }
        
        if (!success) {
            System.out.println("Card blocked — too many incorrect attempts");
        }
    }

    public static void main(String[] args) {
        System.out.print("Test 1: ");
        atmPinRetry("4821", new String[]{"1111", "4821"});
        System.out.print("Test 2: ");
        atmPinRetry("4821", new String[]{"1111", "2222", "3333"});
    }
}