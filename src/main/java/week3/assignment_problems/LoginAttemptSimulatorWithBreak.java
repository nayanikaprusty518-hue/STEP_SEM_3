package week3.assignment_problems;

public class LoginAttemptSimulatorWithBreak {
    public static void simulateLogin(String correctCode, String[] attempts) {
        for (int i = 0; i < attempts.length; i++) {
            if (attempts[i].equals(correctCode)) {
                System.out.println("Access granted on attempt " + (i + 1));
                return;
            }
        }
        System.out.println("Access denied — all attempts used");
    }

    public static void main(String[] args) {
        System.out.print("Test 1: ");
        simulateLogin("1234", new String[]{"0000", "1234", "9999"});
        System.out.print("Test 2: ");
        simulateLogin("1234", new String[]{"1111", "2222", "3333"});
    }
}