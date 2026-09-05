package week2.class_problems;

public class BankTransactionReferenceGenerator {
    public static String normalizeReference(String raw) {
        if (raw == null) {
            return "";
        }
        String trimmed = raw.trim();
        if (trimmed.length() < 3) {
            return trimmed.toUpperCase();
        }
        String bankCode = trimmed.substring(0, 3).toUpperCase();
        String rest = trimmed.substring(3);
        return bankCode + rest;
    }

    public static String validateAndFormat(String reference) {
        String normalized = normalizeReference(reference);

        if (normalized.length() != 14) {
            return "Invalid: wrong length (expected 14, got " + normalized.length() + ")";
        }

        for (int i = 0; i < 3; i++) {
            if (!Character.isLetter(normalized.charAt(i))) {
                return "Invalid: bank code must be 3 letters";
            }
        }

        for (int i = 3; i < 14; i++) {
            if (!Character.isDigit(normalized.charAt(i))) {
                return "Invalid: reference body must be 11 digits";
            }
        }

        String bankCode = normalized.substring(0, 3);
        String dateStr = normalized.substring(3, 9);
        String seq = normalized.substring(9);

        String day = dateStr.substring(0, 2);
        String month = dateStr.substring(2, 4);
        String year = dateStr.substring(4, 6);

        StringBuilder formatted = new StringBuilder();
        formatted.append("[").append(bankCode).append("]");
        formatted.append(" DATE: ").append(day).append("/").append(month).append("/").append(year);
        formatted.append(" | SEQ: ").append(seq);

        return formatted.toString();
    }

    public static void main(String[] args) {
        System.out.println("Test 1: " + validateAndFormat(" hdf03022600042 "));
        System.out.println("Test 2: " + validateAndFormat("12F03022600042"));
    }
}