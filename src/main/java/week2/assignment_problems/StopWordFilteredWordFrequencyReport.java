package week2.assignment_problems;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class StopWordFilteredWordFrequencyReport {
    private static final Set<String> STOP_WORDS = Set.of("the", "was", "and", "a", "is", "of", "in");

    public static void printFilteredWordFrequency(String feedback) {
        if (feedback == null || feedback.trim().isEmpty()) {
            return;
        }

        String cleaned = feedback.toLowerCase()
            .replace(".", "")
            .replace(",", "");

        String[] words = cleaned.split("\\s+");

        Map<String, Integer> frequency = new HashMap<>();
        for (String word : words) {
            if (!STOP_WORDS.contains(word) && !word.isEmpty()) {
                frequency.put(word, frequency.getOrDefault(word, 0) + 1);
            }
        }

        List<Map.Entry<String, Integer>> entries = new ArrayList<>(frequency.entrySet());
        entries.sort((e1, e2) -> e2.getValue().compareTo(e1.getValue()));

        for (Map.Entry<String, Integer> entry : entries) {
            System.out.println(entry.getKey() + ": " + entry.getValue());
        }
    }

    public static void main(String[] args) {
        System.out.println("Test 1:");
        printFilteredWordFrequency("The mentor was great, the session was great and clear.");
    }
}