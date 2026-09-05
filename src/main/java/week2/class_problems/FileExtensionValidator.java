package week2.class_problems;

public class FileExtensionValidator {
    public static String validateFileExtension(String filename) {
        if (filename == null || filename.isEmpty()) {
            return "Rejected — invalid file type";
        }

        int lastDotIndex = filename.lastIndexOf('.');
        if (lastDotIndex == -1 || lastDotIndex == filename.length() - 1) {
            return "Rejected — invalid file type";
        }

        String extension = filename.substring(lastDotIndex + 1).toLowerCase();

        if (extension.equals("pdf") || extension.equals("docx") || extension.equals("zip")) {
            return "Accepted";
        } else {
            return "Rejected — invalid file type";
        }
    }

    public static void main(String[] args) {
        System.out.println("Test 1: " + validateFileExtension("Assignment1.PDF"));
        System.out.println("Test 2: " + validateFileExtension("notes.txt"));
    }
}