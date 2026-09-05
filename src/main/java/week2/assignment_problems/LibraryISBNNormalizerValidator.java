package week2.assignment_problems;

public class LibraryISBNNormalizerValidator {
    public static String normalizeCode(String raw) {
        if (raw == null) {
            return "";
        }
        String trimmed = raw.trim();
        if (trimmed.length() < 3) {
            return trimmed.toUpperCase();
        }
        String pubCode = trimmed.substring(0, 3).toUpperCase();
        String rest = trimmed.substring(3);
        return pubCode + rest;
    }

    public static String validateAndFormat(String code) {
        String normalized = normalizeCode(code);

        if (normalized.length() != 13) {
            return "Invalid: wrong length (expected 13, got " + normalized.length() + ")";
        }

        for (int i = 0; i < 3; i++) {
            if (!Character.isLetter(normalized.charAt(i))) {
                return "Invalid: publisher code must be 3 letters";
            }
        }

        for (int i = 3; i < 13; i++) {
            if (!Character.isDigit(normalized.charAt(i))) {
                return "Invalid: code body must be 10 digits";
            }
        }

        String pubCode = normalized.substring(0, 3);
        String yearStr = normalized.substring(3, 7);
        String catalog = normalized.substring(7);

        StringBuilder formatted = new StringBuilder();
        formatted.append("[").append(pubCode).append("]");
        formatted.append(" YEAR: ").append(yearStr);
        formatted.append(" | CATALOG: ").append(catalog);

        return formatted.toString();
    }

    public static void main(String[] args) {
        System.out.println("Test 1: " + validateAndFormat(" pen2026004251 "));
        System.out.println("Test 2: " + validateAndFormat("12N2026004251"));
    }
}