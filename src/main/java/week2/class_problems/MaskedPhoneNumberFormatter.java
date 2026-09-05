package week2.class_problems;

public class MaskedPhoneNumberFormatter {
    public static String maskPhoneNumber(String phone) {
        if (phone == null || phone.length() != 10) {
            return "Invalid phone number";
        }

        for (int i = 0; i < phone.length(); i++) {
            if (!Character.isDigit(phone.charAt(i))) {
                return "Invalid phone number";
            }
        }

        StringBuilder masked = new StringBuilder();
        masked.append("XXXXXX");
        masked.append("-");
        masked.append(phone.substring(6));

        return masked.toString();
    }

    public static void main(String[] args) {
        System.out.println("Test 1: " + maskPhoneNumber("9876543210"));
        System.out.println("Test 2: " + maskPhoneNumber("98765"));
    }
}