package week1.assignment_problems;

public class TrafficSignalStreakAnalyzer {
    public static void findLongestStreak(String signalLog) {
        if (signalLog == null || signalLog.isEmpty()) {
            System.out.println("No signal data provided");
            return;
        }

        char longestColor = signalLog.charAt(0);
        int longestStreak = 1;
        int currentStreak = 1;

        for (int i = 1; i < signalLog.length(); i++) {
            if (signalLog.charAt(i) == signalLog.charAt(i - 1)) {
                currentStreak++;
            } else {
                currentStreak = 1;
            }

            if (currentStreak > longestStreak) {
                longestStreak = currentStreak;
                longestColor = signalLog.charAt(i);
            }
        }

        System.out.println("Longest Streak: '" + longestColor + "' repeated " + longestStreak + " times");
    }

    public static void main(String[] args) {
        System.out.print("Test 1: ");
        findLongestStreak("RRGGGYRR");

        System.out.print("Test 2: ");
        findLongestStreak("RRRRYYGG");
    }
}