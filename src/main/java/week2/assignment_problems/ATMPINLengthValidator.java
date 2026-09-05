package week2.assignment_problems;

public class ATMPINLengthValidator {
    public static void checkPinLength(String pin) {
        if (pin == null) {
            System.out.println("Invalid PIN — must be exactly 4 digits.");
            return;
        }

        if (pin.length() != 4) {
            System.out.println("Invalid PIN — must be exactly 4 digits.");
        } else {
            System.out.println("PIN length OK.");
        }
    }

    public static void main(String[] args) {
        System.out.print("Test 1: ");
        checkPinLength("482");

        System.out.print("Test 2: ");
        checkPinLength("4820");
    }
}