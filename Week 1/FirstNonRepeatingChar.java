import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class FirstNonRepeatingChar {
    public static char findFirstNonRepeatingChar(String text) {
        if (text == null || text.isEmpty()) return '\0';

        Map<Character, Integer> freq = new HashMap<>();
        for (char c : text.toCharArray()) {
            freq.put(c, freq.getOrDefault(c, 0) + 1);
        }

        for (char c : text.toCharArray()) {
            if (freq.get(c) == 1) {
                return c;
            }
        }
        return '\0';
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter a word or sentence: ");
        String input = scanner.nextLine();

        char result = findFirstNonRepeatingChar(input);

        if (result != '\0') {
            System.out.println("First Non-Repeating Character: '" + result + "'");
        } else {
            System.out.println("No Non-Repeating Character Found");
        }

        scanner.close();
    }
}